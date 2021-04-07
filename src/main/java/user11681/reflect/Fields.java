package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.gudenau.lib.unsafe.Unsafe;

public class Fields {
    public static final long modifiersOffset;
    public static final long overrideOffset;

    private static final MethodHandle getDeclaredFields;

    private static final HashMap<Class<?>, Field[]> fieldCache = new HashMap<>();
    private static final HashMap<Class<?>, Field[]> staticFieldCache = new HashMap<>();
    private static final HashMap<Class<?>, Field[]> instanceFieldCache = new HashMap<>();
    private static final HashMap<String, Field> nameToField = new HashMap<>();

    private static final Field NOT_FOUND = null;

    public static Field getField(Object object, String name) {
        Class<?> klass = object.getClass();
        Field field;

        while (klass != null) {
            if ((field = getField(klass, name)) != null) {
                return field;
            }

            klass = klass.getSuperclass();
        }

        return NOT_FOUND;
    }

    public static Field getField(String klass, String name) {
        return getField(Classes.load(klass), name);
    }

    public static Field getField(Class<?> klass, String name) {
        final Field field = nameToField.get(klass.getName() + '.' + name);

        if (field != null) {
            return field;
        }

        getFields(klass);

        return nameToField.get(klass.getName() + '.' + name);
    }

    public static Field getRawField(Object object, String name) {
        Class<?> klass = object.getClass();
        Field field;

        while (klass != null) {
            if ((field = getRawField(klass, name)) != null) {
                return field;
            }

            klass = klass.getSuperclass();
        }

        return NOT_FOUND;
    }

    public static Field getRawField(String klass, String name) {
        return getRawField(Classes.load(klass), name);
    }

    public static Field getRawField(Class<?> klass, String name) {
        for (Field field : getRawFields(klass)) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return NOT_FOUND;
    }

    public static Field[] getInstanceFields(Class<?> klass) {
        Field[] fields = instanceFieldCache.get(klass);

        if (fields != null) {
            return fields;
        }

        fields = getFields(klass);

        final List<Integer> instanceIndexes = new ArrayList<>();

        for (int i = 0, length = fields.length; i < length; i++) {
            if ((fields[i].getModifiers() & Modifier.STATIC) == 0) {
                instanceIndexes.add(i);
            }
        }

        final int instanceFieldCount = instanceIndexes.size();
        final Field[] instanceFields = new Field[instanceFieldCount];
        int size = 0;

        for (int i = 0; i < instanceFieldCount; i++) {
            instanceFields[size++] = fields[instanceIndexes.get(i)];
        }

        instanceFieldCache.put(klass, instanceFields);

        return instanceFields;
    }

    public static Field[] getStaticFields(Class<?> klass) {
        Field[] fields = staticFieldCache.get(klass);

        if (fields != null) {
            return fields;
        }

        fields = getFields(klass);

        final List<Integer> staticIndexes = new ArrayList<>();

        for (int i = 0, length = fields.length; i < length; i++) {
            if ((fields[i].getModifiers() & Modifier.STATIC) != 0) {
                staticIndexes.add(i);
            }
        }

        final int staticFieldCount = staticIndexes.size();
        final Field[] staticFields = new Field[staticFieldCount];
        int size = 0;

        for (int i = 0; i < staticFieldCount; i++) {
            staticFields[size++] = fields[staticIndexes.get(i)];
        }

        staticFieldCache.put(klass, staticFields);

        return staticFields;
    }

    public static ArrayList<Field> getAllFields(Class<?> klass) {
        final ArrayList<Field> fields = new ArrayList<>(Arrays.asList(getFields(klass)));

        klass = klass.getSuperclass();

        while (klass != null) {
            fields.addAll(new ArrayList<>(Arrays.asList(getFields(klass))));

            klass = klass.getSuperclass();
        }

        return fields;
    }

    public static Field[] getFields(Class<?> klass) {
        Field[] fields = fieldCache.get(klass);

        if (fields == null) {
            fields = getRawFields(klass);
            fieldCache.put(klass, fields);

            for (Field field : fields) {
                nameToField.put(klass.getName() + '.' + field.getName(), field);
            }
        }

        return fields;
    }

    public static Field[] getRawFields(Class<?> klass) {
        try {
            return (Field[]) getDeclaredFields.invokeExact(klass);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        try {
            Method[] methods = Class.class.getDeclaredMethods();
            MethodHandle tempGetDeclaredFields = null;

            for (Method method : methods) {
                if ((method.getModifiers() & Modifier.NATIVE) != 0 && method.getReturnType() == Field[].class) {
                    tempGetDeclaredFields = Invoker.unreflectSpecial(method, Class.class);

                    if (method.getParameterCount() > 0) {
                        tempGetDeclaredFields = MethodHandles.insertArguments(tempGetDeclaredFields, 1, false);
                    }

                    break;
                }
            }

            getDeclaredFields = tempGetDeclaredFields;

            long offset = -1;

            for (Field field : getRawFields(Field.class)) {
                if (field.getName().equals("modifiers")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            modifiersOffset = offset;

            for (Field field : getRawFields(AccessibleObject.class)) {
                if (field.getName().equals("override")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            overrideOffset = offset;

            Unsafe.putObjectVolatile(Classes.Reflection, Unsafe.staticFieldOffset(getField(Classes.Reflection, "fieldFilterMap")), new HashMap<>());
            Unsafe.putObjectVolatile(Classes.Reflection, Unsafe.staticFieldOffset(getField(Classes.Reflection, "methodFilterMap")), new HashMap<>());
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
