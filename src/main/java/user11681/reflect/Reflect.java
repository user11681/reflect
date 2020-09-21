package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

public class Reflect {
    public static final boolean JAVA_9;

    private static final MethodHandle defineClass0;
    private static final MethodHandle defineClass1;
    private static final MethodHandle defineClass2;
    private static final MethodHandle defineClass3;
    private static final MethodHandle getDeclaredFields0;

    private static final boolean DEFINE_CLASS_HAS_BOOLEAN;
    private static final int MODIFIERS_OFFSET;

    public static <T> Class<T> defineClass(final ClassLoader classLoader, final byte[] bytecode) {
        try {
            return (Class<T>) defineClass0.invokeExact(classLoader, bytecode, 0, bytecode.length);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> Class<T> defineClass(final ClassLoader classLoader, final byte[] bytecode, final int offset, final int length) {
        try {
            return (Class<T>) defineClass0.invokeExact(classLoader, bytecode, offset, length);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> Class<T> defineClass(final ClassLoader classLoader, final String name, final byte[] bytecode, final int offset, final int length) {
        try {
            return (Class<T>) defineClass1.invokeExact(classLoader, name, bytecode, offset, length);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> Class<T> defineClass(final ClassLoader classLoader, final String name, final byte[] bytecode, final int offset, final int length, final ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass2.invokeExact(classLoader, name, bytecode, offset, length, protectionDomain);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> Class<T> defineClass(final ClassLoader classLoader, final String name, final ByteBuffer bytecode, final ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass3.invokeExact(classLoader, name, bytecode, protectionDomain);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Field getAccessibleField(final Class<?> klass, final String name) {
        try {
            for (final Field field : getFields(klass)) {
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
            for (final Field field : getFields(klass)) {
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
            final Field[] fields = getFields(klass);

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
            return DEFINE_CLASS_HAS_BOOLEAN
                ? (Field[]) getDeclaredFields0.invokeExact(klass, false)
                : (Field[]) getDeclaredFields0.invokeExact(klass);
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

            defineClass0 = Unsafe.trustedLookup.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, byte[].class, int.class, int.class));
            defineClass1 = Unsafe.trustedLookup.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class));
            defineClass2 = Unsafe.trustedLookup.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class, ProtectionDomain.class));
            defineClass3 = Unsafe.trustedLookup.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, ByteBuffer.class, ProtectionDomain.class));

            final Method[] methods = Class.class.getDeclaredMethods();
            Method found = null;

            for (final Method method : methods) {
                if ((method.getModifiers() & Modifier.NATIVE) != 0 && method.getReturnType() == Field[].class) {
                    found = method;

                    break;
                }
            }

            if (found == null) {
                throw new Throwable();
            } else {
                getDeclaredFields0 = Unsafe.trustedLookup.unreflectSpecial(found, Class.class);
            }

            DEFINE_CLASS_HAS_BOOLEAN = found.getParameterCount() > 0;
            MODIFIERS_OFFSET = (int) Unsafe.objectFieldOffset(getField(Field.class, "modifiers"));

            final Class<?> Reflection = Class.forName(JAVA_9 ? "jdk.internal.reflect.Reflection" : "sun.reflect.Reflection");

            Unsafe.putObjectVolatile(Reflection, Unsafe.staticFieldOffset(getField(Reflection, "fieldFilterMap")), new HashMap<>());
            Unsafe.putObjectVolatile(Reflection, Unsafe.staticFieldOffset(getField(Reflection, "methodFilterMap")), new HashMap<>());
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
