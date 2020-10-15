package user11681.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.SecureClassLoader;
import net.gudenau.lib.unsafe.Unsafe;

public class Classes {
    public static final SecureClassLoader systemClassLoader = (SecureClassLoader) ClassLoader.getSystemClassLoader();

    public static final Class<?> URLClassPath;
    public static final Class<?> Reflection;

    public static final int addressFactor;
    public static final long classOffset;
    public static final long fieldOffset;
    public static final boolean longClassPointer;
    public static final boolean x64;

    private static final MethodHandle findLoadedClass;
    private static final MethodHandle addURL;
    private static final MethodHandle getURLs;
    private static final MethodHandle defineClass0;
    private static final MethodHandle defineClass1;
    private static final MethodHandle defineClass2;
    private static final MethodHandle defineClass3;
    private static final MethodHandle defineClass4;
    private static final MethodHandle defineClass5;

    private static final ClassLoader classLoader = Classes.class.getClassLoader();

    /**
     * Change the class of <a color = "#DDDDDD">{@code object}</a> to the class represented by <a color = "#DDDDDD">{@code klass}</a> such that {@code object.getClass().getName() == klass}.
     *
     * @param object the object whose class pointer to change.
     * @param klass the name of class to set as <a color = "#DDDDDD">{@code object}</a>'s class.
     * @param <T> the desired new type.
     * @return <a color = "#DDDDDD">{@code object}</a>.
     */
    public static <T> T setClass(final Object object, final String klass) {
        return setClass(object, load(classLoader, false, klass));
    }

    /**
     * Change the class of <a color = "#DDDDDD">{@code object}</a> to <a color = "#DDDDDD">{@code klass}</a> such that {@code object.getClass() == klass}.
     *
     * @param object the object whose class pointer to change.
     * @param klass the class to set as <a color = "#DDDDDD">{@code object}</a>'s class.
     * @param <T> the desired new type.
     * @return <a color = "#DDDDDD">{@code object}</a>.
     */
    public static <T> T setClass(final Object object, final Class<T> klass) {
        return copyClass(object, Unsafe.allocateInstance(klass));
    }

    /**
     * Change the class of <a color = "#DDDDDD">{@code to}</a> to that of <a color = "#DDDDDD">{@code from}</a> such that {@code to.getClass() == from.getClass()}.
     *
     * @param to the object whose class pointer to change.
     * @param from the object from which to get the class pointer.
     * @param <T> the desired new type.
     * @return <a color = "#DDDDDD">{@code to}</a>.
     */
    public static <T> T copyClass(final Object to, final T from) {
        if (longClassPointer) {
            Unsafe.putLong(to, classOffset, Unsafe.getLong(from, classOffset));
        } else {
            Unsafe.putInt(to, classOffset, Unsafe.getInt(from, classOffset));
        }

        return (T) to;
    }

    public static <T> T cast(final Object object) {
        return (T) object;
    }

    public static <T> T getDefaultValue(final Class<? extends Annotation> annotationType, final String elementName) {
        try {
            return (T) annotationType.getDeclaredMethod(elementName).getDefaultValue();
        } catch (final NoSuchMethodException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> Class<T> findLoadedClass(final ClassLoader loader, final String klass) {
        try {
            return (Class<T>) findLoadedClass.invokeExact(loader, klass);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

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
        try {
            addURL.invoke(getClassPath(classLoader), url);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void addURL(final ClassLoader classLoader, final URL... urls) {
        final Object classPath = getClassPath(classLoader);

        for (final URL url : urls) {
            try {
                addURL.invoke(classPath, url);
            } catch (final Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        }
    }

    public static void addURL(final Object classPath, final URL url) {
        try {
            addURL.invoke(classPath, url);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void addURL(final Object classPath, final URL... urls) {
        try {
            for (final URL url : urls) {
                addURL.invoke(classPath, url);
            }
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Object getClassPath(final ClassLoader classLoader) {
        return Accessor.getObject(classLoader, getClassPathField(classLoader.getClass()));
    }

    public static Field getClassPathField(final Class<?> loaderClass) {
        Class<?> klass = loaderClass;

        while (klass != Object.class) {
            for (final Field field : Fields.getFields(klass)) {
                if (URLClassPath.isAssignableFrom(field.getType())) {
                    return field;
                }
            }

            klass = klass.getSuperclass();
        }

        throw new IllegalArgumentException(String.format("%s does not have a URLClassPath", loaderClass));
    }

    public static void load(final String... classes) {
        for (final String klass : classes) {
            try {
                Class.forName(klass, true, classLoader);
            } catch (final ClassNotFoundException exception) {
                throw Unsafe.throwException(exception);
            }
        }
    }

    public static void load(final ClassLoader loader, final String... classes) {
        for (final String klass : classes) {
            try {
                Class.forName(klass, true, loader);
            } catch (final ClassNotFoundException exception) {
                throw Unsafe.throwException(exception);
            }
        }
    }

    public static void load(final ClassLoader loader, final boolean initialize, final String... classes) {
        for (final String klass : classes) {
            try {
                Class.forName(klass, initialize, loader);
            } catch (final ClassNotFoundException exception) {
                throw Unsafe.throwException(exception);
            }
        }
    }

    public static <T> Class<T> load(final String name) {
        try {
            return (Class<T>) Class.forName(name, true, classLoader);
        } catch (final ClassNotFoundException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static <T> Class<T> load(final ClassLoader loader, final String name) {
        try {
            return (Class<T>) Class.forName(name, true, loader);
        } catch (final ClassNotFoundException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static <T> Class<T> load(final ClassLoader loader, final boolean initialize, final String name) {
        try {
            return (Class<T>) Class.forName(name, initialize, loader);
        } catch (final ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> Class<T> defineBootstrapClass(final ClassLoader resourceLoader, final String name) {
        try {
            final URL url = resourceLoader.getResource(name.replace('.', '/') + ".class");
            final InputStream stream = url.openStream();
            final byte[] bytecode = new byte[stream.available()];

            while (stream.read(bytecode) != -1) {}

            return Unsafe.defineClass(name, bytecode, 0, bytecode.length, null, new ProtectionDomain(new CodeSource(url, (CodeSigner[]) null), null, null, null));
        } catch (final IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> Class<T> defineSystemClass(final ClassLoader resourceLoader, final String name) {
        try {
            final URL url = resourceLoader.getResource(name.replace('.', '/') + ".class");
            final InputStream stream = url.openStream();
            final byte[] bytecode = new byte[stream.available()];

            while (stream.read(bytecode) != -1) {}

            return defineClass(systemClassLoader, name, bytecode, 0, bytecode.length, new CodeSource(url, (CodeSigner[]) null));
        } catch (final IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> Class<T> defineClass(final ClassLoader resourceLoader, final ClassLoader classLoader, final String name) {
        return defineClass(resourceLoader, classLoader, name, null);
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> Class<T> defineClass(final ClassLoader resourceLoader, final ClassLoader classLoader, final String name, final ProtectionDomain protectionDomain) {
        try {
            final InputStream stream = resourceLoader.getResourceAsStream(name.replace('.', '/') + ".class");
            final byte[] bytecode = new byte[stream.available()];

            while (stream.read(bytecode) != -1) {}

            return defineClass(classLoader, name, bytecode, 0, bytecode.length, protectionDomain);
        } catch (final IOException exception) {
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

    public static <T> Class<T> defineClass(final SecureClassLoader classLoader, final String name, final byte[] bytecode, final int offset, final int length, final CodeSource codeSource) {
        try {
            return (Class<T>) defineClass4.invokeExact(classLoader, name, bytecode, offset, length, codeSource);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> Class<T> defineClass(final SecureClassLoader classLoader, final String name, final ByteBuffer bytecode, final CodeSource codeSource) {
        try {
            return (Class<T>) defineClass5.invokeExact(classLoader, name, bytecode, codeSource);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    static {
        Reflect.disableSecurity();

        Reflection = load(classLoader, Reflect.java9 ? "jdk.internal.reflect.Reflection" : "sun.reflect.Reflection");
        URLClassPath = load(classLoader, Reflect.java9 ? "jdk.internal.loader.URLClassPath" : "sun.misc.URLClassPath");

        findLoadedClass = Invoker.findVirtual(ClassLoader.class, "findLoadedClass", MethodType.methodType(Class.class, String.class));

        addURL = Invoker.findVirtual(URLClassPath, "addURL", MethodType.methodType(void.class, URL.class));
        getURLs = Invoker.findVirtual(URLClassPath, "getURLs", MethodType.methodType(URL[].class));

        defineClass0 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, byte[].class, int.class, int.class));
        defineClass1 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class));
        defineClass2 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class, ProtectionDomain.class));
        defineClass3 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, ByteBuffer.class, ProtectionDomain.class));
        defineClass4 = Invoker.findVirtual(SecureClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class, CodeSource.class));
        defineClass5 = Invoker.findVirtual(SecureClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, ByteBuffer.class, CodeSource.class));

        final byte[] byteArray = new byte[0];
        final short[] shortArray = new short[0];

        long offset = 0;

        while (Unsafe.getInt(byteArray, offset) == Unsafe.getInt(shortArray, offset)) {
            offset += 4;
        }

        classOffset = offset;
        fieldOffset = Unsafe.objectFieldOffset(Fields.getField(Integer.class, "value"));

        if (fieldOffset == 8) { // 32bit jvm
            x64 = false;
            longClassPointer = false;
        } else if (fieldOffset == 12) { // 64bit jvm with compressed OOPs
            x64 = true;
            longClassPointer = false;
        } else if (fieldOffset == 16) { // 64bit jvm
            x64 = true;
            longClassPointer = true;
        } else {
            throw new IllegalStateException("unsupported field offset. Report this exception to https://github.com/user11681/reflect/issues.");
        }

        addressFactor = x64 ? 8 : 1;
    }
}
