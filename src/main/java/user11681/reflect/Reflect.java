package user11681.reflect;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

public class Reflect {
    public static final boolean JAVA_9;

    public static final MethodHandle addURL;

    private static final MethodHandle defineClass0;
    private static final MethodHandle defineClass1;
    private static final MethodHandle defineClass2;
    private static final MethodHandle defineClass3;
    private static final MethodHandle getDeclaredFields0;

    private static final boolean DEFINE_CLASS_HAS_BOOLEAN;
    private static final int MODIFIERS_OFFSET;

    public static int getInt(final Field field) {
        return Unsafe.getInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putInt(final Field field, final int value) {
        Unsafe.putInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getInt(final Object object, final Field field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(field));
    }

    public static void putInt(final Object object, final Field field, final int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObject(final Field field) {
        return (T) Unsafe.getObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObject(final Field field, final Object value) {
        Unsafe.putObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObject(final Object object, final Field field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObject(final Object object, final Field field, final Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBoolean(final Field field) {
        return Unsafe.getBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBoolean(final Field field, final boolean value) {
        Unsafe.putBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBoolean(final Object object, final Field field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBoolean(final Object object, final Field field, final boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByte(final Field field) {
        return Unsafe.getByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByte(final Field field, final byte value) {
        Unsafe.putByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByte(final Object object, final Field field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByte(final Object object, final Field field, final byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShort(final Field field) {
        return Unsafe.getShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShort(final Field field, final short value) {
        Unsafe.putShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShort(final Object object, final Field field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShort(final Object object, final Field field, final short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getChar(final Object object, final Field field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(field));
    }

    public static void putChar(final Field field, final char value) {
        Unsafe.putChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getChar(final Field field) {
        return Unsafe.getChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putChar(final Object object, final Field field, final char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLong(final Field field) {
        return Unsafe.getLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLong(final Field field, final long value) {
        Unsafe.putLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLong(final Object object, final Field field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLong(final Object object, final Field field, final long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloat(final Field field) {
        return Unsafe.getFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloat(final Field field, final float value) {
        Unsafe.putFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloat(final Object object, final Field field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloat(final Object object, final Field field, final float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDouble(final Field field) {
        return Unsafe.getDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDouble(final Field field, final double value) {
        Unsafe.putDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDouble(final Object object, final Field field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDouble(final Object object, final Field field, final double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(field), value);
    }

    public static int getIntVolatile(final Field field) {
        return Unsafe.getIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putIntVolatile(final Field field, final int value) {
        Unsafe.putIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getIntVolatile(final Object object, final Field field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putIntVolatile(final Object object, final Field field, final int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(final Field field) {
        return (T) Unsafe.getObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObjectVolatile(final Field field, final Object value) {
        Unsafe.putObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(final Object object, final Field field) {
        return (T) Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObjectVolatile(final Object object, final Field field, final Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(final Field field) {
        return Unsafe.getBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBooleanVolatile(final Field field, final boolean value) {
        Unsafe.putBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(final Object object, final Field field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBooleanVolatile(final Object object, final Field field, final boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByteVolatile(final Field field) {
        return Unsafe.getByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByteVolatile(final Field field, final byte value) {
        Unsafe.putByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByteVolatile(final Object object, final Field field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByteVolatile(final Object object, final Field field, final byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShortVolatile(final Field field) {
        return Unsafe.getShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShortVolatile(final Field field, final short value) {
        Unsafe.putShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShortVolatile(final Object object, final Field field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShortVolatile(final Object object, final Field field, final short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getCharVolatile(final Field field) {
        return Unsafe.getCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putCharVolatile(final Field field, final char value) {
        Unsafe.putCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getCharVolatile(final Object object, final Field field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putCharVolatile(final Object object, final Field field, final char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLongVolatile(final Field field) {
        return Unsafe.getLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLongVolatile(final Field field, final long value) {
        Unsafe.putLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLongVolatile(final Object object, final Field field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLongVolatile(final Object object, final Field field, final long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloatVolatile(final Field field) {
        return Unsafe.getFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloatVolatile(final Field field, final float value) {
        Unsafe.putFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloatVolatile(final Object object, final Field field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloatVolatile(final Object object, final Field field, final float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDoubleVolatile(final Field field) {
        return Unsafe.getDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDoubleVolatile(final Field field, final double value) {
        Unsafe.putDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDoubleVolatile(final Object object, final Field field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDoubleVolatile(final Object object, final Field field, final double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getDefaultValue(final Class<? extends Annotation> annotationType, final String elementName) {
        try {
            return (T) annotationType.getDeclaredMethod(elementName).getDefaultValue();
        } catch (final NoSuchMethodException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> Class<T> loadClass(final String name) {
        try {
            return (Class<T>) Class.forName(name);
        } catch (final ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> Class<T> loadClass(final String name, final boolean initialize, final ClassLoader loader) {
        try {
            return (Class<T>) Class.forName(name, initialize, loader);
        } catch (final ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void addURL(final URLClassLoader classLoader, final URL url) {
        try {
            addURL.invokeExact(classLoader, url);
        } catch (Throwable throwable) {
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

    public static <T> Class<T> defineClass(final ClassLoader classLoader, final String name, final byte[] bytecode) {
        try {
            return (Class<T>) defineClass1.invokeExact(classLoader, name, bytecode, 0, bytecode.length);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> Class<T> defineClass(final ClassLoader classLoader, final String name, final byte[] bytecode, final ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass2.invokeExact(classLoader, name, bytecode, 0, bytecode.length, protectionDomain);
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

            addURL = Unsafe.trustedLookup.findVirtual(URLClassLoader.class, "addURL", MethodType.methodType(void.class, URL.class));

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
