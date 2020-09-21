package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

public class Reflect {
    public static final boolean JAVA_9;

    private static final MethodHandle getDeclaredFields0;

    private static final int MODIFIERS_OFFSET;

    public static void main(final String[] args) {}

    public static Field getAccessibleField(final Class<?> klass, final String name) {
        try {
            final Field[] fields = (Field[]) getDeclaredFields0.invokeExact(klass, false);

            for (final Field field : fields) {
                if (name.equals(field.getName())) {
                    field.setAccessible(true);

                    Unsafe.putInt(field, MODIFIERS_OFFSET, Unsafe.getInt(field, MODIFIERS_OFFSET) & ~Modifier.FINAL);

                    return field;
                }
            }

            throw new IllegalArgumentException(String.format("field %s does not exist in %s.", name, klass));
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Field getField(final Class<?> klass, final String name) {
        try {
            final Field[] fields = (Field[]) getDeclaredFields0.invokeExact(klass, false);

            for (final Field field : fields) {
                if (name.equals(field.getName())) {
                    return field;
                }
            }

            throw new IllegalArgumentException(String.format("field %s does not exist in %s.", name, klass));
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Field[] getAccessibleFields(final Class<?> klass) {
        try {
            final Field[] fields = (Field[]) getDeclaredFields0.invokeExact(klass, false);

            for (final Field field : fields) {
                field.setAccessible(true);

                Unsafe.putInt(field, MODIFIERS_OFFSET, Unsafe.getInt(field, MODIFIERS_OFFSET) & ~Modifier.FINAL);
            }

            return fields;
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Field[] getFields(final Class<?> klass) {
        try {
            return (Field[]) getDeclaredFields0.invokeExact(klass, false);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Field[] getFields(final Class<?> klass, final boolean publicOnly) {
        try {
            return (Field[]) getDeclaredFields0.invokeExact(klass, publicOnly);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    static {
        try {
            final String version = System.getProperty("java.version");

            if (JAVA_9 = version.indexOf('.') != 1 || version.indexOf(2) == '9') {
                final Class<?> IllegalAccessLogger = Class.forName("jdk.internal.module.IllegalAccessLogger");
                final Field logger = IllegalAccessLogger.getDeclaredField("logger");

                Unsafe.putObjectVolatile(IllegalAccessLogger, Unsafe.staticFieldOffset(logger), null);
            }

            getDeclaredFields0 = Unsafe.trustedLookup.findVirtual(Class.class, "getDeclaredFields0", MethodType.methodType(Field[].class, boolean.class));

            MODIFIERS_OFFSET = (int) Unsafe.objectFieldOffset(getField(Field.class, "modifiers"));

            final Class<?> Reflection = Class.forName(JAVA_9 ? "jdk.internal.reflect.Reflection" : "sun.reflect.Reflection");

            Unsafe.putObjectVolatile(Reflection, Unsafe.staticFieldOffset(getField(Reflection, "fieldFilterMap")), new HashMap<>());
            Unsafe.putObjectVolatile(Reflection, Unsafe.staticFieldOffset(getField(Reflection, "methodFilterMap")), new HashMap<>());
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
