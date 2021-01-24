package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

public class EnumConstructor<E extends Enum<E>> {
    private static final int ENUM_ARRAY = Modifier.PRIVATE | Modifier.STATIC | 1 << 12 /*synthetic*/ | Modifier.FINAL;

    private static final Object NOT_FOUND = null;

    private static final HashMap<Class<?>, Pointer> arrayFields = new HashMap<>();
    private static final HashMap<Class<?>, EnumConstructor<?>> constructors = new HashMap<>();

    private static final MethodHandle getEnumVars;
    private static final MethodHandle acquireConstructorAccessor = Invoker.unreflect(Constructor.class, "acquireConstructorAccessor");
    private static final MethodHandle newInstance0 = Invoker.findStatic(Classes.NativeConstructorAccessorImpl, "newInstance0", Object.class, Constructor.class, Object[].class);

    private static final Pointer enumConstantPointer;
    private static final Pointer enumConstantDirectoryPointer;

    public final Class<E> enumClass;
    public final MethodHandle newInstance;

    protected EnumConstructor(Class<E> enumClass, Class<?>... parameterTypes) {
        this(enumClass, getConstructor(enumClass, parameterTypes));
    }

    protected EnumConstructor(Class<E> enumClass, Constructor<?> constructor) {
        this.enumClass = enumClass;
        this.newInstance = newInstance0.bindTo(constructor);
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(Class<E> enumClass, Object... arguments) {
        return get(true, enumClass, arguments);
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(boolean unbox, Class<E> enumClass, Object... arguments) {
        EnumConstructor<E> constructor = (EnumConstructor<E>) constructors.get(enumClass);

        if (constructor != null) {
            return constructor;
        }

        constructor = new EnumConstructor<>(enumClass, findConstructor(unbox, enumClass, arguments));
        constructors.put(enumClass, constructor);

        return constructor;
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(Class<E> enumClass) {
        return (EnumConstructor<E>) constructors.get(enumClass);
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(Class<E> enumClass, Class<?>... parameterTypes) {
        EnumConstructor<E> constructor = (EnumConstructor<E>) constructors.get(enumClass);

        if (constructor != null) {
            return constructor;
        }

        constructor = new EnumConstructor<>(enumClass, parameterTypes);
        constructors.put(enumClass, constructor);

        return constructor;
    }

    public static <E extends Enum<E>> E add(Class<E> enumClass, String name, Object... arguments) {
        return add(true, enumClass, getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E add(Class<E> enumClass, int ordinal, String name, Object... arguments) {
        return add(true, enumClass, ordinal, name, arguments);
    }

    public static <E extends Enum<E>> E add(boolean unbox, Class<E> enumClass, String name, Object... arguments) {
        return add(unbox, enumClass, getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E add(boolean unbox, Class<E> enumClass, int ordinal, String name, Object... arguments) {
        return add(enumClass, newInstance(unbox, enumClass, ordinal, name, arguments));
    }

    public static <E extends Enum<E>> E add(Class<E> enumClass, E enumConstant) {
        final Pointer enumArrayPointer = getEnumArray(enumClass);
        final Object[] values = enumArrayPointer.get();
        final Object[] newValues = Arrays.copyOf(values, values.length + 1);
        newValues[values.length] = enumConstant;

        enumArrayPointer.put(newValues);
        getEnumConstants(enumClass).put(newValues);
        getEnumConstantDirectory(enumClass).put(null);

        return enumConstant;
    }

    public static <E extends Enum<E>> E newInstance(Class<E> enumClass, String name, Object... arguments) {
        return get(true, enumClass, arguments).newInstance(getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E newInstance(Class<E> enumClass, int ordinal, String name, Object... arguments) {
        return get(true, enumClass, arguments).newInstance(ordinal, name, arguments);
    }

    public static <E extends Enum<E>> E newInstance(boolean unbox, Class<E> enumClass, String name, Object... arguments) {
        return get(unbox, enumClass, arguments).newInstance(getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E newInstance(boolean unbox, Class<E> enumClass, int ordinal, String name, Object... arguments) {
        return get(unbox, enumClass, arguments).newInstance(ordinal, name, arguments);
    }

    public static <E extends Enum<?>> Constructor<E> findConstructor(Class<E> enumClass, Object... arguments) {
        return findConstructor(true, enumClass, arguments);
    }

    public static <E extends Enum<?>> Constructor<E> findConstructor(boolean unbox, Class<E> enumClass, Object... arguments) {
        for (Constructor<?> declaredConstructor : enumClass.getDeclaredConstructors()) {
            if (Methods.argumentsMatchParameters(unbox, 2, declaredConstructor, arguments)) {
                return (Constructor<E>) declaredConstructor;
            }
        }

        return (Constructor<E>) NOT_FOUND;
    }

    public static <E> Constructor<E> getConstructor(Class<E> enumClass, Class<?>... parameterTypes) {
        try {
            final Class<?>[] trueParameterTypes = new Class<?>[parameterTypes.length + 2];
            trueParameterTypes[0] = String.class;
            trueParameterTypes[1] = int.class;

            System.arraycopy(parameterTypes, 0, trueParameterTypes, 2, parameterTypes.length);

            return enumClass.getDeclaredConstructor(trueParameterTypes);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public Object[] joinArguments(int ordinal, String name, Object... others) {
        final int length = others.length;
        final Object[] arguments = new Object[length + 2];
        arguments[0] = name;
        arguments[1] = ordinal;

        System.arraycopy(others, 0, arguments, 2, length);

        return arguments;
    }

    public static Pointer getEnumConstantDirectory(Class<?> klass) {
        if (getEnumVars == null) {
            return enumConstantDirectoryPointer.clone().bind(klass);
        }

        try {
            return enumConstantDirectoryPointer.clone().bind(getEnumVars.invoke(klass));
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static Pointer getEnumConstants(Class<?> klass) {
        if (getEnumVars == null) {
            return enumConstantPointer.clone().bind(klass);
        }

        try {
            return enumConstantPointer.clone().bind(getEnumVars.invoke(klass));
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static Pointer getEnumArray(Class<?> enumClass) {
        Pointer pointer = arrayFields.get(enumClass);

        if (pointer != null) {
            return pointer;
        }

        pointer = new Pointer().bind(enumClass);

        final Field[] fields = Fields.getRawFields(enumClass);

        for (Field field : fields) {
            if (isArrayField(field)) {
                arrayFields.put(enumClass, pointer = pointer.staticField(field));

                enumClass.getEnumConstants();

                return pointer;
            }
        }

        return (Pointer) NOT_FOUND;
    }

    public static boolean isArrayField(Field field) {
        if ((field.getModifiers() & ENUM_ARRAY) != ENUM_ARRAY) {
            return false;
        }

        final Class<?> owner = field.getDeclaringClass();

        return owner.isEnum() && field.getType().getComponentType() == owner;
    }

    public static int getNextOrdinal(Class<?> enumClass) {
        return enumClass.getEnumConstants().length;
    }

    public E add(String name, Object... arguments) {
        return this.add(getNextOrdinal(this.enumClass), name);
    }

    public E add(int ordinal, String name, Object... arguments) {
        return add(this.enumClass, this.newInstance(ordinal, name, arguments));
    }

    public E newInstance(String name, Object... arguments) {
        return this.newInstance(getNextOrdinal(this.enumClass), name, arguments);
    }

    public E newInstance(int ordinal, String name, Object... arguments) {
        try {
            return (E) (Object) this.newInstance.invokeExact(joinArguments(ordinal, name, arguments));
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        Class<?> klass = null;

        try {
            klass = Class.forName(Class.class.getName() + "$EnumVars");
        } catch (ClassNotFoundException ignored) {}

        if (klass == null) {
            enumConstantPointer = new Pointer().instanceField(Class.class, "enumConstants");
            enumConstantDirectoryPointer = new Pointer().instanceField(Class.class, "enumConstantDirectory");
            getEnumVars = null;
        } else {
            enumConstantPointer = new Pointer().instanceField(klass, "cachedEnumConstants");
            enumConstantDirectoryPointer = new Pointer().instanceField(klass, "cachedEnumConstantDirectory");
            getEnumVars = Invoker.findSpecial(Class.class, "getEnumVars", klass);
        }
    }
}
