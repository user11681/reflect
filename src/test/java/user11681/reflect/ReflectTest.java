package user11681.reflect;

import java.io.File;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class ReflectTest {
    static final TestObject test = new TestObject();

    @Test
    void bootstrapClassLoaderTest() throws Throwable {
        URL klass = (URL) Invoker.bind(Accessor.getObject(Classes.load("sun.misc.Launcher$BootClassPathHolder"), "bcp"), "findResource", MethodType.methodType(URL.class, String.class, boolean.class)).invokeExact("user11681.reflect.Reflect", false);

        Classes.addBootstrapURL(Classes.class.getProtectionDomain().getCodeSource().getLocation());

        klass = (URL) Invoker.bind(Accessor.getObject(Classes.load("sun.misc.Launcher$BootClassPathHolder"), "bcp"), "findResource", MethodType.methodType(URL.class, String.class, boolean.class)).invokeExact("user11681.reflect.Reflect", false);

        Class.forName("user11681.reflect.Reflect", true, null);
    }

    @Test
    void normalFieldTime() {
        final ThrowingRunnable test = () -> {
            final Field field = TestObject.class.getDeclaredField("integer");

            field.setAccessible(true);

            final Field modifiers = Field.class.getDeclaredField("modifiers");

            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        };

        time(test);
        time(test);
        time(test);
        time(test);
        time(test);
    }

    @Test
    void reflectFieldTime() {
        final ThrowingRunnable test = () -> Fields.getField(TestObject.class, "integer");

        time(test);
        time(test);
        time(test);
        time(test);
        time(test);
    }

    @Test
    void testCopy() {
        final Field[] fields = Fields.getInstanceFields(ReflectTest.class);
        final TestObject one = new TestObject();
        final TestObject two = new TestObject();

        logFields(one);

        System.out.println();
        System.out.println();
        System.out.println();

        logFields(two);

        System.out.println();
        System.out.println();
        System.out.println();

        for (final Method method : Accessor.class.getDeclaredMethods()) {
            final String name = method.getName();

            if (name.startsWith("copy")) {
                final String typeName = name.substring(name.indexOf('y') + 1).toLowerCase();

                for (final Field field : fields) {
                    final String fieldTypeName = field.getType().getSimpleName().toLowerCase();

                    if (fieldTypeName.equals(typeName)) {
                        Accessor.copyObject(one, two, field);
                    } else if (fieldTypeName.replace("Volatile", "").equals(typeName)) {
                        Accessor.copyObjectVolatile(one, two, field);
                    }
                }
            }
        }

        logFields(one);
    }

    @Test
    void test() throws Throwable {
        final Object classPath = Classes.getClassPath(ReflectTest.class.getClassLoader());
        final File file = new File("test");

        for (final URL url : Classes.getURLs(classPath)) {
            Logger.log(url);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        Classes.addURL(classPath, file.toURL());

        for (final URL url : Classes.getURLs(classPath)) {
            Logger.log(url);
        }
    }

    public static <T> T invokeStatic(final Class<?> klass, final String name, final MethodType methodType, final Object... arguments) throws Throwable {
        return (T) Unsafe.trustedLookup.findStatic(klass, name, methodType).invokeWithArguments(arguments);
    }

    static void logFields(final Object object) {
        for (final Field field : Fields.getInstanceFields(object.getClass())) {
            System.out.printf("%s: %s\n", field, Accessor.getObject(object, field));
        }
    }

    static void time(final ThrowingRunnable test) {
        try {
            final long start = System.nanoTime();

            test.run();

            System.out.println(System.nanoTime() - start);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    static {
        Classes.load("user11681.reflect.Reflect");
    }
}
