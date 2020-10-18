package user11681.reflect;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

@SuppressWarnings("ConstantConditions")
public class Fields {
    public static final long modifiersOffset;
    public static final long overrideOffset;

    private static final MethodHandle getDeclaredFields;

    private static final boolean getDeclaredFieldsHasBoolean;

    private static final Reference2ReferenceOpenHashMap<Class<?>, Field[]> fieldCache = new Reference2ReferenceOpenHashMap<>();
    private static final Reference2ReferenceOpenHashMap<Class<?>, Field[]> staticFieldCache = new Reference2ReferenceOpenHashMap<>();
    private static final Reference2ReferenceOpenHashMap<Class<?>, Field[]> instanceFieldCache = new Reference2ReferenceOpenHashMap<>();
    private static final Object2ReferenceOpenHashMap<String, Field> nameToField = new Object2ReferenceOpenHashMap<>();

    private static final Field NOT_FOUND = null;

    public static Field getField(final Object object, final String name) {
        Class<?> klass = object.getClass();
        Field field;

        while (klass != Object.class) {
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

    public static Field[] getFields(final Class<?> klass) {
        Field[] fields = fieldCache.get(klass);

        if (fields == null) {
            fields = getRawFields(klass);

            fieldCache.put(klass, fields);

            for (final Field field : fields) {
                Unsafe.putBoolean(field, overrideOffset, true);
                Unsafe.putInt(field, modifiersOffset, field.getModifiers() & ~Modifier.FINAL);

                nameToField.put(klass.getName() + '.' + field.getName(), field);
            }
        }

        return fields;
    }

    public static Field[] getRawFields(final Class<?> klass) {
        try {
            return getDeclaredFieldsHasBoolean
                ? (Field[]) getDeclaredFields.invokeExact(klass, false)
                : (Field[]) getDeclaredFields.invokeExact(klass);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        Reflect.disableSecurity();

        final Method[] methods = Class.class.getDeclaredMethods();
        Method found = null;

        for (final Method method : methods) {
            if ((method.getModifiers() & Modifier.NATIVE) != 0 && method.getReturnType() == Field[].class) {
                found = method;

                break;
            }
        }

        getDeclaredFields = Invoker.unreflectSpecial(found, Class.class);

        getDeclaredFieldsHasBoolean = found.getParameterCount() > 0;

        try {
            Field[] fields = getDeclaredFieldsHasBoolean
                ? (Field[]) getDeclaredFields.invokeExact(Field.class, false)
                : (Field[]) getDeclaredFields.invokeExact(Field.class);

            long offset = -1;

            for (final Field field : fields) {
                if (field.getName().equals("modifiers")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            modifiersOffset = offset;

            fields = getDeclaredFieldsHasBoolean
                ? (Field[]) getDeclaredFields.invokeExact(AccessibleObject.class, false)
                : (Field[]) getDeclaredFields.invokeExact(AccessibleObject.class);

            for (final Field field : fields) {
                if (field.getName().equals("override")) {
                    offset = Unsafe.objectFieldOffset(field);

                    break;
                }
            }

            overrideOffset = offset;

            final Class<?> Reflection = Classes.Reflection;

            Accessor.putObjectVolatile(Reflection, "fieldFilterMap", new HashMap<>());
            Accessor.putObjectVolatile(Reflection, "methodFilterMap", new HashMap<>());

            final Field security = Fields.getField(System.class, "security");

            if (Modifier.isVolatile(security.getModifiers())) {
                Accessor.putObject(security, null);
            } else {
                Accessor.putObjectVolatile(security, null);
            }
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
