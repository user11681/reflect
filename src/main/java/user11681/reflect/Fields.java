package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import net.gudenau.lib.unsafe.Unsafe;

public class Fields {
    public static final long modifiersOffset;
    public static final long overrideOffset;

    private static final MethodHandle getDeclaredFields;

    private static final IdentityHashMap<Class<?>, Field[]> cache = new IdentityHashMap<>();
    private static final IdentityHashMap<Class<?>, ArrayList<Field>> staticFieldCache = new IdentityHashMap<>();
    private static final IdentityHashMap<Class<?>, ArrayList<Field>> instanceFieldCache = new IdentityHashMap<>();
    private static final HashMap<String, Field> nameToField = new HashMap<>();

    @Deprecated
    private static final IdentityHashMap<Class<?>, Field[]> oldStaticFieldCache = new IdentityHashMap<>();

    @Deprecated
    private static final IdentityHashMap<Class<?>, Field[]> oldInstanceFieldCache = new IdentityHashMap<>();

    private static final Field notFound = null;

    public static Field anyField(Object object, String name) {
        return anyField(object.getClass(), name);
    }

    public static Field anyField(String klass, String name) {
        return anyField(Classes.load(klass), name);
    }

    public static Field field(Object object, String name) {
        return field(object.getClass(), name);
    }

    public static Field field(String klass, String name) {
        return field(Classes.load(klass), name);
    }

    public static Field anyField(Class<?> type, String name) {
        Field currentField;

        while (type != Object.class) {
            if ((currentField = field(type, name)) != null) {
                return currentField;
            }

            type = type.getSuperclass();
        }

        return notFound;
    }

    public static Field field(Class<?> type, String name) {
        String key = type.getName() + '@' + name;
        Field field = nameToField.get(key);

        if (field != null) {
            return field;
        }

        fields(type);

        return nameToField.get(key);
    }

    public static Field anyRawField(Object object, String name) {
        return anyRawField(object.getClass(), name);
    }

    public static Field anyRawField(String klass, String name) {
        return anyRawField(Classes.load(klass), name);
    }

    public static Field anyRawField(Class<?> type, String name) {
        Field currentField;

        while (type != Object.class) {
            if ((currentField = rawField(type, name)) != null) {
                return currentField;
            }

            type = type.getSuperclass();
        }

        return notFound;
    }

    public static Field rawField(Object object, String name) {
        return rawField(object.getClass(), name);
    }

    public static Field rawField(String klass, String name) {
        return rawField(Classes.load(klass), name);
    }

    public static Field rawField(Class<?> klass, String name) {
        for (Field field : rawFields(klass)) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return notFound;
    }

    public static List<Field> all(Object object) {
        return all(object.getClass());
    }

    public static List<Field> all(Class<?> type) {
        List<Field> fields = new ArrayList<>();

        while (type != Object.class) {
            Collections.addAll(fields, fields(type));

            type = type.getSuperclass();
        }

        return fields;
    }

    public static List<Field> staticFields(Class<?> type) {
        ArrayList<Field> fields = staticFieldCache.get(type);

        if (fields != null) {
            return fields;
        }

        fields = new ArrayList<>();

        for (Field field : fields(type)) {
            if (Modifier.isStatic(field.getModifiers())) {
                fields.add(field);
            }
        }

        staticFieldCache.put(type, fields);

        return fields;
    }

    public static List<Field> instanceFields(Object object) {
        return instanceFields(object.getClass());
    }

    public static List<Field> instanceFields(Class<?> type) {
        ArrayList<Field> fields = instanceFieldCache.get(type);

        if (fields != null) {
            return fields;
        }

        fields = new ArrayList<>();

        for (Field field : fields(type)) {
            if (!Modifier.isStatic(field.getModifiers())) {
                fields.add(field);
            }
        }

        instanceFieldCache.put(type, fields);

        return fields;
    }

    public static Field[] fields(Class<?> klass) {
        Field[] fields = cache.get(klass);

        if (fields == null) {
            fields = rawFields(klass);
            cache.put(klass, fields);

            for (Field field : fields) {
                nameToField.put(klass.getName() + '@' + field.getName(), field);
            }
        }

        return fields;
    }

    public static List<Field> allInstanceFields(Object object) {
        return allInstanceFields(object.getClass());
    }

    public static List<Field> allInstanceFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();

        while (type != Object.class) {
            fields.addAll(instanceFields(type));

            type = type.getSuperclass();
        }

        return fields;
    }

    public static List<Field> allStaticFields(Object object) {
        return allStaticFields(object.getClass());
    }

    public static List<Field> allStaticFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();

        while (type != Object.class) {
            fields.addAll(staticFields(type));

            type = type.getSuperclass();
        }

        return fields;
    }

    /**
     * @deprecated by {@link #field(Class, String)}
     */
    public static Field getField(Class<?> klass, String name) {
        Field field = nameToField.get(klass.getName() + '@' + name);

        if (field != null) {
            return field;
        }

        fields(klass);

        return nameToField.get(klass.getName() + '@' + name);
    }

    /**
     * @deprecated by {@link #rawField(Object, String)}
     */
    public static Field getRawField(Object object, String name) {
        Class<?> klass = object.getClass();
        Field field;

        while (klass != Object.class) {
            if ((field = getRawField(klass, name)) != null) {
                return field;
            }

            klass = klass.getSuperclass();
        }

        return notFound;
    }

    public static Field[] rawFields(Class<?> klass) {
        try {
            return (Field[]) getDeclaredFields.invokeExact(klass);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    /**
     * @deprecated by {@link #field(Object, String)}
     */
    public static Field getField(Object object, String name) {
        Class<?> klass = object.getClass();
        Field field;

        while (klass != Object.class) {
            if ((field = getField(klass, name)) != null) {
                return field;
            }

            klass = klass.getSuperclass();
        }

        return notFound;
    }

    /**
     * @deprecated by {@link #field(String, String)}
     */
    public static Field getField(String klass, String name) {
        return getField(Classes.load(klass), name);
    }

    /**
     * @deprecated by {@link #rawField(String, String)}
     */
    public static Field getRawField(String klass, String name) {
        return getRawField(Classes.load(klass), name);
    }

    /**
     * @deprecated by {@link #rawField(Class, String)}
     */
    public static Field getRawField(Class<?> klass, String name) {
        for (Field field : rawFields(klass)) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return notFound;
    }

    /**
     * @deprecated by {@link #instanceFields}
     */
    public static Field[] getInstanceFields(Class<?> type) {
        Field[] fields = oldInstanceFieldCache.get(type);

        if (fields != null) {
            return fields;
        }

        List<Field> fieldList = new ArrayList<>();

        for (Field field : fields(type)) {
            if ((field.getModifiers() & Modifier.STATIC) == 0) {
                fieldList.add(field);
            }
        }

        fields = fieldList.toArray(new Field[0]);
        oldInstanceFieldCache.put(type, fields);

        return fields;
    }

    /**
     * @deprecated by {@link #staticFields}
     */
    public static Field[] getStaticFields(Class<?> type) {
        Field[] fields = oldStaticFieldCache.get(type);

        if (fields != null) {
            return fields;
        }

        List<Field> fieldList = new ArrayList<>();

        for (Field field : fields(type)) {
            if ((field.getModifiers() & Modifier.STATIC) != 0) {
                fieldList.add(field);
            }
        }

        fields = fieldList.toArray(new Field[0]);
        oldStaticFieldCache.put(type, fields);

        return fields;

    }

    /**
     * @deprecated by {@link #all}
     */
    public static List<Field> getAllFields(Class<?> klass) {
        final List<Field> fields = new ArrayList<>(Arrays.asList(fields(klass)));

        klass = klass.getSuperclass();

        while (klass != null) {
            fields.addAll(Arrays.asList(fields(klass)));

            klass = klass.getSuperclass();
        }

        return fields;
    }

    /**
     * @deprecated by {@link #fields}
     */
    public static Field[] getFields(Class<?> klass) {
        Field[] fields = cache.get(klass);

        if (fields == null) {
            fields = rawFields(klass);
            cache.put(klass, fields);

            for (Field field : fields) {
                nameToField.put(klass.getName() + '@' + field.getName(), field);
            }
        }

        return fields;
    }

    /**
     * @deprecated by {@link #rawFields}
     */
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

            for (Field field : rawFields(Field.class)) {
                if (field.getName().equals("modifiers")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            modifiersOffset = offset;

            for (Field field : rawFields(AccessibleObject.class)) {
                if (field.getName().equals("override")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            overrideOffset = offset;

            Unsafe.putObjectVolatile(Classes.Reflection, Unsafe.staticFieldOffset(field(Classes.Reflection, "fieldFilterMap")), new HashMap<>());
            Unsafe.putObjectVolatile(Classes.Reflection, Unsafe.staticFieldOffset(field(Classes.Reflection, "methodFilterMap")), new HashMap<>());
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
