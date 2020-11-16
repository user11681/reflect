package user11681.reflect;

import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import net.gudenau.lib.unsafe.Unsafe;

public class EnumConstructor<E extends Enum<E>> {
    private static final int ENUM_ARRAY = Modifier.PRIVATE | Modifier.STATIC | 0x1000 | Modifier.FINAL;

    private static final Object NOT_FOUND = null;

    private static final Reference2ReferenceOpenHashMap<Class<?>, Pointer> arrayFields = new Reference2ReferenceOpenHashMap<>();
    private static final Reference2ReferenceOpenHashMap<Class<?>, EnumConstructor<?>> constructors = new Reference2ReferenceOpenHashMap<>();

    private static final MethodHandle getEnumVars;
    private static final MethodHandle acquireConstructorAccessor = Invoker.unreflect(Constructor.class, "acquireConstructorAccessor");
    private static final MethodHandle newInstance0 = Invoker.findStatic(Classes.NativeConstructorAccessorImpl, "newInstance0", Object.class, Constructor.class, Object[].class);

    private static final Pointer enumConstantPointer;
    private static final Pointer enumConstantDirectoryPointer;

    public final Class<E> enumClass;
    public final MethodHandle newInstance;

    protected EnumConstructor(final Class<E> enumClass, final Class<?>... parameterTypes) {
        this(enumClass, getConstructor(enumClass, parameterTypes));
    }

    protected EnumConstructor(final Class<E> enumClass, final Constructor<?> constructor) {
        this.enumClass = enumClass;
        this.newInstance = newInstance0.bindTo(constructor);
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(final Class<E> enumClass, final Object... arguments) {
        return get(true, enumClass, arguments);
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(final boolean unbox, final Class<E> enumClass, final Object... arguments) {
        EnumConstructor<E> constructor = (EnumConstructor<E>) constructors.get(enumClass);

        if (constructor != null) {
            return constructor;
        }

        constructor = new EnumConstructor<>(enumClass, findConstructor(unbox, enumClass, arguments));
        constructors.put(enumClass, constructor);

        return constructor;
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(final Class<E> enumClass) {
        return (EnumConstructor<E>) constructors.get(enumClass);
    }

    public static <E extends Enum<E>> EnumConstructor<E> get(final Class<E> enumClass, final Class<?>... parameterTypes) {
        EnumConstructor<E> constructor = (EnumConstructor<E>) constructors.get(enumClass);

        if (constructor != null) {
            return constructor;
        }

        constructor = new EnumConstructor<>(enumClass, parameterTypes);
        constructors.put(enumClass, constructor);

        return constructor;
    }

    public static <E extends Enum<E>> E add(final Class<E> enumClass, final String name, final Object... arguments) {
        return add(true, enumClass, getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E add(final Class<E> enumClass, final int ordinal, final String name, final Object... arguments) {
        return add(true, enumClass, ordinal, name, arguments);
    }

    public static <E extends Enum<E>> E add(final boolean unbox, final Class<E> enumClass, final String name, final Object... arguments) {
        return add(unbox, enumClass, getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E add(final boolean unbox, final Class<E> enumClass, final int ordinal, final String name, final Object... arguments) {
        return add(enumClass, newInstance(unbox, enumClass, ordinal, name, arguments));
    }

    public static <E extends Enum<E>> E add(final Class<E> enumClass, final E enumConstant) {
        final Pointer enumArrayPointer = getEnumArray(enumClass);
        final Object[] values = enumArrayPointer.get();
        final Object[] newValues = Arrays.copyOf(values, values.length + 1);
        newValues[values.length] = enumConstant;

        enumArrayPointer.put(newValues);
        getEnumConstants(enumClass).put(newValues);
        getEnumConstantDirectory(enumClass).put(null);

        return enumConstant;
    }

    public static <E extends Enum<E>> E newInstance(final Class<E> enumClass, final String name, final Object... arguments) {
        return get(true, enumClass, arguments).newInstance(getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E newInstance(final Class<E> enumClass, final int ordinal, final String name, final Object... arguments) {
        return get(true, enumClass, arguments).newInstance(ordinal, name, arguments);
    }

    public static <E extends Enum<E>> E newInstance(final boolean unbox, final Class<E> enumClass, final String name, final Object... arguments) {
        return get(unbox, enumClass, arguments).newInstance(getNextOrdinal(enumClass), name, arguments);
    }

    public static <E extends Enum<E>> E newInstance(final boolean unbox, final Class<E> enumClass, final int ordinal, final String name, final Object... arguments) {
        return get(unbox, enumClass, arguments).newInstance(ordinal, name, arguments);
    }

    public static <E extends Enum<?>> Constructor<E> findConstructor(final Class<E> enumClass, final Object... arguments) {
        return findConstructor(true, enumClass, arguments);
    }

    public static <E extends Enum<?>> Constructor<E> findConstructor(final boolean unbox, final Class<E> enumClass, final Object... arguments) {
        for (final Constructor<?> declaredConstructor : enumClass.getDeclaredConstructors()) {
            if (Methods.argumentsMatchParameters(unbox, 2, declaredConstructor, arguments)) {
                return (Constructor<E>) declaredConstructor;
            }
        }

        return (Constructor<E>) NOT_FOUND;
    }

    public static <E> Constructor<E> getConstructor(final Class<E> enumClass, final Class<?>... parameterTypes) {
        try {
            final Class<?>[] trueParameterTypes = new Class<?>[parameterTypes.length + 2];
            trueParameterTypes[0] = String.class;
            trueParameterTypes[1] = int.class;

            System.arraycopy(parameterTypes, 0, trueParameterTypes, 2, parameterTypes.length);

            return enumClass.getDeclaredConstructor(trueParameterTypes);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public Object[] joinArguments(final int ordinal, final String name, final Object... others) {
        final int length = others.length;
        final Object[] arguments = new Object[length + 2];
        arguments[0] = name;
        arguments[1] = ordinal;

        System.arraycopy(others, 0, arguments, 2, length);

        return arguments;
    }

    public static Pointer getEnumConstantDirectory(final Class<?> klass) {
        if (getEnumVars == null) {
            return enumConstantDirectoryPointer.clone().bind(klass);
        }

        try {
            return enumConstantDirectoryPointer.clone().bind(getEnumVars.invoke(klass));
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static Pointer getEnumConstants(final Class<?> klass) {
        if (getEnumVars == null) {
            return enumConstantPointer.clone().bind(klass);
        }

        try {
            return enumConstantPointer.clone().bind(getEnumVars.invoke(klass));
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static Pointer getEnumArray(final Class<?> enumClass) {
        Pointer pointer = arrayFields.get(enumClass);

        if (pointer != null) {
            return pointer;
        }

        pointer = new Pointer().bind(enumClass);

        final Field[] fields = Fields.getRawFields(enumClass);

        for (final Field field : fields) {
            if (isArrayField(field)) {
                arrayFields.put(enumClass, pointer = pointer.staticField(field));

                enumClass.getEnumConstants();

                return pointer;
            }
        }

        return (Pointer) NOT_FOUND;
    }

    public static boolean isArrayField(final Field field) {
        if ((field.getModifiers() & ENUM_ARRAY) != ENUM_ARRAY) {
            return false;
        }

        final Class<?> owner = field.getDeclaringClass();

        return owner.isEnum() && field.getType().getComponentType() == owner;
    }

    public static int getNextOrdinal(final Class<?> enumClass) {
        return enumClass.getEnumConstants().length;
    }

    public E add(final String name, final Object... arguments) {
        return this.add(getNextOrdinal(this.enumClass), name);
    }

    public E add(final int ordinal, final String name, final Object... arguments) {
        return add(this.enumClass, this.newInstance(ordinal, name, arguments));
    }

    public E newInstance(final String name, final Object... arguments) {
        return this.newInstance(getNextOrdinal(this.enumClass), name, arguments);
    }

    public E newInstance(final int ordinal, final String name, final Object... arguments) {
        try {
            return (E) (Object) this.newInstance.invokeExact(joinArguments(ordinal, name, arguments));
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        Class<?> klass = null;

        try {
            klass = Class.forName(Class.class.getName() + "$EnumVars");
        } catch (final ClassNotFoundException ignored) {}

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
