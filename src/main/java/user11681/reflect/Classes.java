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
    public static final Class<?> URLClassPath;

    public static final SecureClassLoader systemClassLoader = (SecureClassLoader) ClassLoader.getSystemClassLoader();

    private static final MethodHandle findLoadedClass;

    private static final MethodHandle addURL;
    private static final MethodHandle getURLs;

    private static final MethodHandle defineClass0;
    private static final MethodHandle defineClass1;
    private static final MethodHandle defineClass2;
    private static final MethodHandle defineClass3;
    private static final MethodHandle defineClass4;
    private static final MethodHandle defineClass5;

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
                Class.forName(klass);
            } catch (final ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public static void load(final ClassLoader loader, final String... classes) {
        for (final String klass : classes) {
            try {
                Class.forName(klass, true, loader);
            } catch (final ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public static void load(final ClassLoader loader, final boolean initialize, final String... classes) {
        for (final String klass : classes) {
            try {
                Class.forName(klass, initialize, loader);
            } catch (final ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public static <T> Class<T> load(final String name) {
        try {
            return (Class<T>) Class.forName(name);
        } catch (final ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> Class<T> load(final ClassLoader loader, final String name) {
        try {
            return (Class<T>) Class.forName(name, true, loader);
        } catch (final ClassNotFoundException exception) {
            throw new RuntimeException(exception);
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

        URLClassPath = load(Reflect.java9 ? "jdk.internal.loader.URLClassPath" : "sun.misc.URLClassPath");

        findLoadedClass = Invoker.findVirtual(ClassLoader.class, "findLoadedClass", MethodType.methodType(Class.class, String.class));

        addURL = Invoker.findVirtual(URLClassPath, "addURL", MethodType.methodType(void.class, URL.class));
        getURLs = Invoker.findVirtual(URLClassPath, "getURLs", MethodType.methodType(URL[].class));

        defineClass0 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, byte[].class, int.class, int.class));
        defineClass1 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class));
        defineClass2 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class, ProtectionDomain.class));
        defineClass3 = Invoker.findVirtual(ClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, ByteBuffer.class, ProtectionDomain.class));
        defineClass4 = Invoker.findVirtual(SecureClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class, CodeSource.class));
        defineClass5 = Invoker.findVirtual(SecureClassLoader.class, "defineClass", MethodType.methodType(Class.class, String.class, ByteBuffer.class, CodeSource.class));
    }
}
