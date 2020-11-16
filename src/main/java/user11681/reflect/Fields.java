package user11681.reflect;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

public class Fields {
    public static final long modifiersOffset;
    public static final long overrideOffset;

    private static final MethodHandle getDeclaredFields;

    private static final Reference2ReferenceOpenHashMap<Class<?>, Field[]> fieldCache = new Reference2ReferenceOpenHashMap<>();
    private static final Reference2ReferenceOpenHashMap<Class<?>, Field[]> staticFieldCache = new Reference2ReferenceOpenHashMap<>();
    private static final Reference2ReferenceOpenHashMap<Class<?>, Field[]> instanceFieldCache = new Reference2ReferenceOpenHashMap<>();
    private static final Object2ReferenceOpenHashMap<String, Field> nameToField = new Object2ReferenceOpenHashMap<>();

    private static final Field NOT_FOUND = null;

    public static Field getField(final Object object, final String name) {
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

    public static Field getField(final String klass, final String name) {
        return getField(Classes.load(klass), name);
    }

    public static Field getField(final Class<?> klass, final String name) {
        final Field field = nameToField.get(klass.getName() + '.' + name);

        if (field != null) {
            return field;
        }

        getFields(klass);

        return nameToField.get(klass.getName() + '.' + name);
    }

    public static Field getRawField(final Object object, final String name) {
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

    public static Field getRawField(final String klass, final String name) {
        for (final Field field : getRawFields(Classes.load(klass))) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return NOT_FOUND;
    }

    public static Field getRawField(final Class<?> klass, final String name) {
        for (final Field field : getRawFields(klass)) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return NOT_FOUND;
    }

    public static Field[] getInstanceFields(final Class<?> klass) {
        Field[] fields = instanceFieldCache.get(klass);

        if (fields != null) {
            return fields;
        }

        fields = getFields(klass);

        final IntArrayList instanceIndexes = new IntArrayList();

        for (int i = 0, length = fields.length; i < length; i++) {
            if ((fields[i].getModifiers() & Modifier.STATIC) == 0) {
                instanceIndexes.add(i);
            }
        }

        final int instanceFieldCount = instanceIndexes.size();
        final Field[] instanceFields = new Field[instanceFieldCount];
        int size = 0;

        final int[] indexArray = instanceIndexes.elements();

        for (int i = 0; i < instanceFieldCount; i++) {
            instanceFields[size++] = fields[indexArray[i]];
        }

        instanceFieldCache.put(klass, instanceFields);

        return instanceFields;
    }

    public static Field[] getStaticFields(final Class<?> klass) {
        Field[] fields = staticFieldCache.get(klass);

        if (fields != null) {
            return fields;
        }

        fields = getFields(klass);

        final IntArrayList staticIndexes = new IntArrayList();

        for (int i = 0, length = fields.length; i < length; i++) {
            if ((fields[i].getModifiers() & Modifier.STATIC) != 0) {
                staticIndexes.add(i);
            }
        }

        final int staticFieldCount = staticIndexes.size();
        final Field[] staticFields = new Field[staticFieldCount];
        int size = 0;

        final int[] indexArray = staticIndexes.elements();

        for (int i = 0; i < staticFieldCount; i++) {
            staticFields[size++] = fields[indexArray[i]];
        }

        staticFieldCache.put(klass, staticFields);

        return staticFields;
    }

    public static ReferenceArrayList<Field> getAllFields(Class<?> klass) {
        final ReferenceArrayList<Field> fields = ReferenceArrayList.wrap(getFields(klass));

        klass = klass.getSuperclass();

        while (klass != null) {
            fields.addElements(fields.size(), getFields(klass));

            klass = klass.getSuperclass();
        }

        return fields;
    }

    public static Field[] getFields(final Class<?> klass) {
        Field[] fields = fieldCache.get(klass);

        if (fields == null) {
            fields = getRawFields(klass);

            fieldCache.put(klass, fields);

            for (final Field field : fields) {
                nameToField.put(klass.getName() + '.' + field.getName(), field);
            }
        }

        return fields;
    }

    public static Field[] getRawFields(final Class<?> klass) {
        try {
            return (Field[]) getDeclaredFields.invokeExact(klass);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        try {
            final Method[] methods = Class.class.getDeclaredMethods();
            MethodHandle tempGetDeclaredFields = null;

            for (final Method method : methods) {
                if ((method.getModifiers() & Modifier.NATIVE) != 0 && method.getReturnType() == Field[].class) {
                    tempGetDeclaredFields = Unsafe.trustedLookup.unreflectSpecial(method, Class.class);

                    if (tempGetDeclaredFields.type().parameterCount() > 1) {
                        tempGetDeclaredFields = MethodHandles.insertArguments(tempGetDeclaredFields, 1, false);
                    }

                    break;
                }
            }

            getDeclaredFields = tempGetDeclaredFields;

            long offset = -1;

            for (final Field field : getRawFields(Field.class)) {
                if (field.getName().equals("modifiers")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            modifiersOffset = offset;

            for (final Field field : getRawFields(AccessibleObject.class)) {
                if (field.getName().equals("override")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            overrideOffset = offset;

            Unsafe.putObjectVolatile(Classes.Reflection, Unsafe.staticFieldOffset(getField(Classes.Reflection, "fieldFilterMap")), new HashMap<>());
            Unsafe.putObjectVolatile(Classes.Reflection, Unsafe.staticFieldOffset(getField(Classes.Reflection, "methodFilterMap")), new HashMap<>());

            final Field security = getRawField(System.class, "security");

            if (Modifier.isVolatile(security.getModifiers())) {
                Unsafe.putObject(security.getDeclaringClass(), Unsafe.staticFieldOffset(security), null);
            } else {
                Unsafe.putObjectVolatile(security.getDeclaringClass(), Unsafe.staticFieldOffset(security), null);
            }
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
