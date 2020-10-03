package user11681.reflect;

import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.HashMap;
import net.gudenau.lib.unsafe.Unsafe;

public class Reflect extends Accessor {
    public static final boolean JAVA_9;

    public static final Class<?> URLClassPath;

    private static final MethodHandle addURL;
    private static final MethodHandle getURLs;
    private static final MethodHandle defineClass0;
    private static final MethodHandle defineClass1;
    private static final MethodHandle defineClass2;
    private static final MethodHandle defineClass3;
    private static final MethodHandle getDeclaredFields0;

    private static final boolean DEFINE_CLASS_HAS_BOOLEAN;
    private static final int MODIFIERS_OFFSET;
    private static final long PARENT_FIELD_OFFSET;

    private static final Object2ReferenceOpenHashMap<Class<?>, Field[]> fieldCache = new Object2ReferenceOpenHashMap<>();

    public static URL[] getURLs(final ClassLoader classLoader) {
        return getURLs(getClassPath(classLoader));
    }

    public static URL[] getURLs(final Object classPath) {
        try {
            return (URL[]) getURLs.invoke(classPath);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void addURL(final ClassLoader classLoader, final URL url) {
        addURL(getClassPath(classLoader), url);
    }

    public static void addURL(final Object classPath, final URL url) {
        try {
            addURL.invoke(classPath, url);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Object getClassPath(final ClassLoader classLoader) {
        return Accessor.getObject(classLoader, getClassPathField(classLoader.getClass()));
    }

    public static Field getClassPathField(final Class<?> loaderClass) {
        Class<?> klass = loaderClass;

        while (klass != Object.class) {
            for (final Field field : getFields(klass)) {
                if (URLClassPath.isAssignableFrom(field.getType())) {
                    return field;
                }
            }

            klass = klass.getSuperclass();
        }

        throw new IllegalArgumentException(String.format("%s does not have a URLClassPath", loaderClass));
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
            Field[] fields = fieldCache.get(klass);

            if (fields != null) {
                return fields;
            }

            fields = DEFINE_CLASS_HAS_BOOLEAN
                ? (Field[]) getDeclaredFields0.invokeExact(klass, false)
                : (Field[]) getDeclaredFields0.invokeExact(klass);

            fieldCache.put(klass, fields);

            return fields;
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

                URLClassPath = loadClass("jdk.internal.loader.URLClassPath");
            } else {
                URLClassPath = loadClass("sun.misc.URLClassPath");
            }

            addURL = Unsafe.trustedLookup.findVirtual(URLClassPath, "addURL", MethodType.methodType(void.class, URL.class));
            getURLs = Unsafe.trustedLookup.findVirtual(URLClassPath, "getURLs", MethodType.methodType(URL[].class));

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
            PARENT_FIELD_OFFSET = Unsafe.objectFieldOffset(getField(ClassLoader.class, "parent"));

            final Class<?> Reflection = Class.forName(JAVA_9 ? "jdk.internal.reflect.Reflection" : "sun.reflect.Reflection");

            Unsafe.putObjectVolatile(Reflection, Unsafe.staticFieldOffset(getField(Reflection, "fieldFilterMap")), new HashMap<>());
            Unsafe.putObjectVolatile(Reflection, Unsafe.staticFieldOffset(getField(Reflection, "methodFilterMap")), new HashMap<>());
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
