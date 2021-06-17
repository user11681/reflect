package user11681.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.gudenau.lib.unsafe.Unsafe;

public class Classes {
    public static final SecureClassLoader systemClassLoader = (SecureClassLoader) ClassLoader.getSystemClassLoader();

    public static final Class<?> ConstantPool;
    public static final Class<?> ConstructorAccessor;
    public static final Class<?> JavaLangAccess;
    public static final Class<?> NativeConstructorAccessorImpl;
    public static final Class<?> Reflection;
    public static final Class<?> SharedSecrets;
    public static final Class<?> URLClassPath;

    public static final Object systemClassPath;

    public static final int addressFactor;
    public static final long classOffset;
    public static final long fieldOffset;
    public static final boolean longClassPointer;
    public static final boolean x64;

    private static final MethodHandle findLoadedClass;
    private static final MethodHandle URLClassPath$addURL;
    private static final MethodHandle URLClassLoader$addURL;
    private static final MethodHandle URLClassLoader$getURLs;
    private static final MethodHandle defineClass0;
    private static final MethodHandle defineClass1;
    private static final MethodHandle defineClass2;
    private static final MethodHandle defineClass3;
    private static final MethodHandle defineClass4;
    private static final MethodHandle defineClass5;

    private static final Object notFound = null;

    /**
     * Change the class of <b>{@code object}</b> to that represented by <b>{@code T}</b> such that <b>{@code to.getClass() == T}</b>.
     *
     * @param object the object whose class pointer to change.
     * @param dummy  a dummy varargs parameter for reifying <b>{@code T}</b>.
     * @param <T>    the desired new type.
     *
     * @return <b>{@code object}</b>.
     */
    @SafeVarargs
    public static <T> T reinterpret(Object object, T... dummy) {
        return (T) reinterpret(object, Unsafe.allocateInstance(dummy.getClass().getComponentType()));
    }

    /**
     * Change the class of <b>{@code object}</b> to the class represented by <b>{@code klass}</b> such that <b>{@code object.getClass().getName().equals(klass)}</b>.
     *
     * @param object the object whose class pointer to change.
     * @param klass  the name of class to set as <b>{@code object}</b>'s class.
     * @param <T>    the desired new type.
     *
     * @return <b>{@code object}</b>.
     */
    public static <T> T reinterpret(Object object, String klass) {
        return reinterpret(object, (T) Unsafe.allocateInstance(load(Reflect.defaultClassLoader, false, klass)));
    }

    /**
     * Change the class of <b>{@code object}</b> to <b>{@code klass}</b> such that <b>{@code object.getClass() == klass}</b>.
     *
     * @param object the object whose class pointer to change.
     * @param klass  the class to set as <b>{@code object}</b>'s class.
     * @param <T>    the desired new type.
     *
     * @return <b>{@code object}</b>.
     */
    public static <T> T reinterpret(Object object, Class<T> klass) {
        return reinterpret(object, Unsafe.allocateInstance(klass));
    }

    /**
     * Change the class of <b>{@code to}</b> to that of <b>{@code from}</b> such that <b>{@code to.getClass() == from.getClass()}</b>.
     *
     * @param to   the object whose class pointer to change.
     * @param from the object from which to get the class pointer.
     * @param <T>  the desired new type.
     *
     * @return <b>{@code to}</b>.
     */
    public static <T> T reinterpret(Object to, T from) {
        if (longClassPointer) {
            Accessor.copyLong(to, from, classOffset);
        } else {
            Accessor.copyInt(to, from, classOffset);
        }

        return (T) to;
    }

    /**
     * Change the class of <b>{@code object}</b> to the class represented by <b>{@code from}</b>.
     *
     * @param object       the object whose class pointer to change.
     * @param classPointer the class pointer.
     * @param <T>          a convenience type parameter for casting.
     *
     * @return <b>{@code to}</b>.
     */
    public static <T> T reinterpret(Object object, long classPointer) {
        if (longClassPointer) {
            Unsafe.putLong(object, classOffset, classPointer);
        } else {
            Unsafe.putInt(object, classOffset, (int) classPointer);
        }

        return (T) object;
    }

    /**
     * Get the <b>{@code Klass*}</b> from a {@link Class}.<br>
     * <b>{@code klass}</b> must not be abstract.
     *
     * @param clas a class.
     *
     * @return the Klass*.
     */
    public static long klass(Class<?> clas) {
        return klass(Unsafe.allocateInstance(clas));
    }

    /**
     * Get the <b>{@code Klass*}</b> of an object.
     *
     * @param object the object.
     *
     * @return its <b>{@code Klass*}</b>.
     */
    public static long klass(Object object) {
        return longClassPointer ? Unsafe.getLong(object, classOffset) : Unsafe.getInt(object, classOffset);
    }

    public static <T> T cast(Object object) {
        return (T) object;
    }

    public static <T> Class<T> findLoadedClass(ClassLoader loader, String klass) {
        try {
            return (Class<T>) findLoadedClass.invokeExact(loader, klass);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static URL[] urls(ClassLoader classLoader) {
        return urls(classPath(classLoader));
    }

    public static URL[] urls(Object classPath) {
        try {
            return (URL[]) URLClassLoader$getURLs.invoke(classPath);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void addSystemURL(URL... url) {
        addURL(systemClassPath, url);
    }

    public static void addSystemURL(URL url) {
        addURL(systemClassPath, url);
    }

    public static void addURL(ClassLoader classLoader, URL... urls) {
        final Object classPath = classPath(classLoader);

        for (URL url : urls) {
            try {
                URLClassPath$addURL.invoke(classPath, url);
            } catch (Throwable throwable) {
                throw Unsafe.throwException(throwable);
            }
        }
    }

    public static void addURL(ClassLoader classLoader, URL url) {
        try {
            URLClassPath$addURL.invoke(classPath(classLoader), url);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void addURL(Object classPath, URL... urls) {
        try {
            for (URL url : urls) {
                URLClassPath$addURL.invoke(classPath, url);
            }
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void addURL(Object classPath, URL url) {
        try {
            URLClassPath$addURL.invoke(classPath, url);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static Object classPath(ClassLoader classLoader) {
        return Accessor.getObject(classLoader, classPathField(classLoader.getClass()));
    }

    public static Field classPathField(Class<?> loaderClass) {
        Class<?> klass = loaderClass;

        while (klass != Object.class) {
            for (Field field : Fields.fields(klass)) {
                if (URLClassPath.isAssignableFrom(field.getType())) {
                    return field;
                }
            }

            klass = klass.getSuperclass();
        }

        return (Field) notFound;
    }

    public static void load(String... classes) {
        load(Reflect.defaultClassLoader, true, classes);
    }

    public static void load(boolean initialize, String... classes) {
        load(Reflect.defaultClassLoader, initialize, classes);
    }

    public static void load(ClassLoader loader, String... classes) {
        load(loader, true, classes);
    }

    public static void load(ClassLoader loader, boolean initialize, String... classes) {
        for (String klass : classes) {
            load(loader, initialize, klass);
        }
    }

    public static <T> Class<T> load(String name) {
        return load(Reflect.defaultClassLoader, true, name);
    }

    public static <T> Class<T> load(boolean initialize, String name) {
        return load(Reflect.defaultClassLoader, initialize, name);
    }

    public static <T> Class<T> load(ClassLoader loader, String name) {
        return load(loader, true, name);
    }

    public static <T> Class<T> load(ClassLoader loader, boolean initialize, String name) {
        try {
            return (Class<T>) Class.forName(name, initialize, loader);
        } catch (ClassNotFoundException exception) {
            return (Class<T>) notFound;
        }
    }

    // todo: Convenience overloads ought to be distinguishable from proxies. Use a builder?

    @SuppressWarnings("ConstantConditions")
    public static <T> Class<T> defineBootstrapClass(ClassLoader resourceLoader, String name) {
        try {
            URL url = resourceLoader.getResource(name.replace('.', '/') + ".class");
            InputStream stream = url.openStream();
            byte[] bytecode = new byte[stream.available()];

            while (stream.read(bytecode) != -1) {}

            return Unsafe.defineClass(name, bytecode, 0, bytecode.length, null, new ProtectionDomain(new CodeSource(url, (CodeSigner[]) null), null, null, null));
        } catch (IOException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> Class<T> defineSystemClass(ClassLoader resourceLoader, String name) {
        try {
            URL url = resourceLoader.getResource(name.replace('.', '/') + ".class");
            InputStream stream = url.openStream();
            byte[] bytecode = new byte[stream.available()];

            while (stream.read(bytecode) != -1) {}

            return defineClass(systemClassLoader, name, bytecode, 0, bytecode.length, new CodeSource(url, (CodeSigner[]) null));
        } catch (IOException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static <T> Class<T> defineClass(ClassLoader resourceLoader, ClassLoader classLoader, String name) {
        return defineClass(resourceLoader, classLoader, name, null);
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> Class<T> defineClass(ClassLoader resourceLoader, ClassLoader classLoader, String name, ProtectionDomain protectionDomain) {
        try {
            InputStream stream = resourceLoader.getResourceAsStream(name.replace('.', '/') + ".class");
            byte[] bytecode = new byte[stream.available()];

            while (stream.read(bytecode) != -1) {}

            return defineClass(classLoader, name, bytecode, 0, bytecode.length, protectionDomain);
        } catch (IOException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static <T> Class<T> defineClass(ClassLoader classLoader, byte[] bytecode, int offset, int length) {
        try {
            return (Class<T>) defineClass0.invokeExact(classLoader, bytecode, offset, length);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static <T> Class<T> defineClass(ClassLoader classLoader, String name, byte[] bytecode) {
        return defineClass(classLoader, name, bytecode, 0, bytecode.length);
    }

    public static <T> Class<T> defineClass(ClassLoader classLoader, String name, byte[] bytecode, int offset, int length) {
        try {
            return (Class<T>) defineClass1.invokeExact(classLoader, name, bytecode, offset, length);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static <T> Class<T> defineClass(ClassLoader classLoader, String name, byte[] bytecode, ProtectionDomain protectionDomain) {
        return defineClass(classLoader, name, bytecode, 0, bytecode.length, protectionDomain);
    }

    public static <T> Class<T> defineClass(ClassLoader classLoader, String name, byte[] bytecode, int offset, int length, ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass2.invokeExact(classLoader, name, bytecode, offset, length, protectionDomain);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static <T> Class<T> defineClass(ClassLoader classLoader, String name, ByteBuffer bytecode, ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass3.invokeExact(classLoader, name, bytecode, protectionDomain);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static <T> Class<T> defineClass(SecureClassLoader classLoader, String name, byte[] bytecode, int offset, int length, CodeSource codeSource) {
        try {
            return (Class<T>) defineClass4.invokeExact(classLoader, name, bytecode, offset, length, codeSource);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static <T> Class<T> defineClass(SecureClassLoader classLoader, String name, ByteBuffer bytecode, CodeSource codeSource) {
        try {
            return (Class<T>) defineClass5.invokeExact(classLoader, name, bytecode, codeSource);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    // todo: end of mess

    public static List<Class<?>> supertypes(Class<?> type) {
        List<Class<?>> supertypes = new ArrayList<>(Arrays.asList(type.getInterfaces()));
        type = type.getSuperclass();

        if (type != null) {
            supertypes.add(type);
        }

        return supertypes;
    }

    public static List<Type> genericSupertypes(Class<?> type) {
        List<Type> supertypes = new ArrayList<>(Arrays.asList(type.getGenericInterfaces()));
        Type superclass = type.getGenericSuperclass();

        if (superclass != null) {
            supertypes.add(superclass);
        }

        return supertypes;
    }

    private static Class<?> tryLoad(String... classes) {
        for (String name : classes) {
            Class<?> klass = load(name);

            if (klass != null) {
                return klass;
            }
        }

        return (Class<?>) notFound;
    }

    static {
        ConstantPool = tryLoad("jdk.internal.reflect.ConstantPool", "sun.reflect.ConstantPool");
        ConstructorAccessor = tryLoad("jdk.internal.reflect.ConstructorAccessor", "sun.reflect.ConstructorAccessor");
        JavaLangAccess = tryLoad("jdk.internal.access.JavaLangAccess", "jdk.internal.misc.JavaLangAccess", "sun.misc.JavaLangAccess");
        NativeConstructorAccessorImpl = tryLoad("jdk.internal.reflect.NativeConstructorAccessorImpl", "sun.reflect.NativeConstructorAccessorImpl");
        Reflection = tryLoad("jdk.internal.reflect.Reflection", "sun.reflect.Reflection");
        SharedSecrets = tryLoad("jdk.internal.access.SharedSecrets", "jdk.internal.misc.SharedSecrets", "sun.misc.SharedSecrets");
        URLClassPath = tryLoad("jdk.internal.loader.URLClassPath", "sun.misc.URLClassPath");

        try {
            findLoadedClass = Invoker.findVirtual(ClassLoader.class, "findLoadedClass", Class.class, String.class);

            URLClassPath$addURL = Invoker.findVirtual(URLClassPath, "addURL", void.class, URL.class);
            URLClassLoader$addURL = Invoker.findVirtual(URLClassLoader.class, "addURL", void.class, URL.class);
            URLClassLoader$getURLs = Invoker.findVirtual(URLClassPath, "getURLs", URL[].class);

            defineClass0 = Invoker.findVirtual(ClassLoader.class, "defineClass", Class.class, byte[].class, int.class, int.class);
            defineClass1 = Invoker.findVirtual(ClassLoader.class, "defineClass", Class.class, String.class, byte[].class, int.class, int.class);
            defineClass2 = Invoker.findVirtual(ClassLoader.class, "defineClass", Class.class, String.class, byte[].class, int.class, int.class, ProtectionDomain.class);
            defineClass3 = Invoker.findVirtual(ClassLoader.class, "defineClass", Class.class, String.class, ByteBuffer.class, ProtectionDomain.class);
            defineClass4 = Invoker.findVirtual(SecureClassLoader.class, "defineClass", Class.class, String.class, byte[].class, int.class, int.class, CodeSource.class);
            defineClass5 = Invoker.findVirtual(SecureClassLoader.class, "defineClass", Class.class, String.class, ByteBuffer.class, CodeSource.class);

            byte[] byteArray = new byte[0];
            short[] shortArray = new short[0];

            long offset = 0;

            while (Unsafe.getInt(byteArray, offset) == Unsafe.getInt(shortArray, offset)) {
                offset += 4;
            }

            classOffset = offset;
            fieldOffset = Unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"));
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }

        if (fieldOffset == 8) { // 32-bit JVM
            x64 = false;
            longClassPointer = false;
            addressFactor = 1;
        } else if (fieldOffset == 12) { // 64-bit JVM with compressed oops
            x64 = true;
            longClassPointer = false;
            addressFactor = 8;
        } else if (fieldOffset == 16) { // 64-bit JVM
            x64 = true;
            longClassPointer = true;
            addressFactor = 1;
        } else {
            throw new Error("unsupported field offset; report to https://github.com/user11681/reflect/issues.");
        }

        systemClassPath = classPath(systemClassLoader);
    }
}
