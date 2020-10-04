package user11681.reflect;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

public class Fields {
    public static final boolean JAVA_9;

    private static final MethodHandle getDeclaredFields;

    private static final boolean DEFINE_CLASS_HAS_BOOLEAN;
    private static final long MODIFIERS_OFFSET;
    private static final long OVERRIDE_OFFSET;

    private static final Object2ReferenceOpenHashMap<Class<?>, Field[]> fieldCache = new Object2ReferenceOpenHashMap<>();
    private static final Object2ReferenceOpenHashMap<Class<?>, Field[]> staticFieldCache = new Object2ReferenceOpenHashMap<>();
    private static final Object2ReferenceOpenHashMap<Class<?>, Field[]> instanceFieldCache = new Object2ReferenceOpenHashMap<>();
    private static final Object2ReferenceOpenHashMap<String, Field> nameToField = new Object2ReferenceOpenHashMap<>();

    public static Field getField(final Object object, final String name) {
        Class<?> klass = object.getClass();
        Field field = null;

        while (klass != Object.class) {
            field = getField(klass, name);

            if (field != null) {
                break;
            }

            klass = klass.getSuperclass();
        }

        return field;
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
        try {
            Field[] fields = fieldCache.get(klass);

            if (fields != null) {
                return fields;
            }

            fields = DEFINE_CLASS_HAS_BOOLEAN
                     ? (Field[]) getDeclaredFields.invokeExact(klass, false)
                     : (Field[]) getDeclaredFields.invokeExact(klass);

            fieldCache.put(klass, fields);

            for (final Field field : fields) {
                Unsafe.putBoolean(field, OVERRIDE_OFFSET, true);
                Unsafe.putInt(field, MODIFIERS_OFFSET, field.getModifiers() & ~Modifier.FINAL);

                nameToField.put(klass.getName() + '.' + field.getName(), field);
            }

            return fields;
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    static {
        final String version = System.getProperty("java.version");
        final Class<?> Reflection;

        if (JAVA_9 = version.indexOf('.') != 1 || version.indexOf(2) == '9') {
            final Class<?> IllegalAccessLogger = Classes.load("jdk.internal.module.IllegalAccessLogger");

            try {
                Accessor.putObjectVolatile(IllegalAccessLogger, IllegalAccessLogger.getDeclaredField("logger"), null);
            } catch (final NoSuchFieldException throwable) {
                throw new RuntimeException(throwable);
            }

            Reflection = Classes.load("jdk.internal.reflect.Reflection");
        } else {
            Reflection = Classes.load("sun.reflect.Reflection");
        }

        final Method[] methods = Class.class.getDeclaredMethods();
        Method found = null;

        for (final Method method : methods) {
            if ((method.getModifiers() & Modifier.NATIVE) != 0 && method.getReturnType() == Field[].class) {
                found = method;

                break;
            }
        }

        getDeclaredFields = Invoker.unreflectSpecial(found, Class.class);

        //noinspection ConstantConditions
        DEFINE_CLASS_HAS_BOOLEAN = found.getParameterCount() > 0;
        MODIFIERS_OFFSET = Unsafe.objectFieldOffset(getField(Field.class, "modifiers"));
        OVERRIDE_OFFSET = Unsafe.objectFieldOffset(getField(AccessibleObject.class, "override"));

        Accessor.putObjectVolatile(Reflection, "fieldFilterMap", new HashMap<>());
        Accessor.putObjectVolatile(Reflection, "methodFilterMap", new HashMap<>());
    }
}
