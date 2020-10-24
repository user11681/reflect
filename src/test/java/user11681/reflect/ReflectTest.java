package user11681.reflect;

import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import net.gudenau.lib.unsafe.Unsafe;
import user11681.reflect.experimental.Classes2;

public class ReflectTest {
    private static final int iterations = 1;
    private static final int tests = 10;

    public static void main(final String[] arguments) throws Throwable {
        for (int i = 0; i < tests; i++) {
            newInvokerUnreflectTest();
        }
    }

    public static void newInvokerUnreflectTest() {
//        timeN("new", () -> Invoker.unreflect2(A.class, "privateMethod"));

        timeN("old", () -> Invoker.unreflect(A.class, "privateMethod"));
    }

    public static void invokerOverload() throws Throwable {
        Logger.log(Invoker.unreflect(Boolean.class, "getBoolean", String.class).invoke("123"));
        Logger.log(Invoker.unreflectConstructor(Boolean.class, boolean.class).invoke(true));
    }

    public static void addClass() {
        Classes2.addClass(String.class, Integer.class);

        final String integer = (String) (Object) 0;
        final Integer string = (Integer) (Object) "";
    }

    public static void allFields() {
        for (final Field field : Fields.getAllFields(C.class)) {
            Logger.log(field);
        }
    }

    public static void unreflectTest() throws Throwable {
        final Method method = Methods.getMethod(A.class, "privateMethod");
        final Method declaredMethod = A.class.getDeclaredMethod("privateMethod");
        final MethodHandle methodHandle = Invoker.findStatic(A.class, "privateMethod", String.class);
        final MethodHandle unreflected = Invoker.unreflect(method);

        timeN("Method 0", () -> {
            Methods.getMethod(A.class, "privateMethod2", int.class);
        });

        timeN("Method 1", () -> {
            Methods.getMethod(A.class, "privateMethod");
        });

        timeN("Method 2", () -> {
            final Method method1 = A.class.getDeclaredMethod("privateMethod");

            method.setAccessible(true);
        });

        timeN("MethodHandle unreflection", () -> {
            Invoker.unreflect(declaredMethod);
        });

        timeN("MethodHandle", () -> {
            Invoker.findStatic(A.class, "privateMethod", String.class);
        });
    }

    public static void methodTest() {
        timeN(() -> Methods.getMethods(TestObject.class));
        timeN(ReflectTest.class::getDeclaredMethods);
    }

    public static void classPointerTest() {
        Object object = Unsafe.allocateInstance(Object.class);

        System.out.println(object);
        Classes.setClass(object, ReflectTest.class);
        System.out.println(object);

        object = Unsafe.allocateInstance(ReflectTest.class);

        System.out.println(object);
        Classes.setClass(object, ReflectTest.class);
        System.out.println(object);

        object = Unsafe.allocateInstance(Object.class);

        System.out.println(object);
        Classes.copyClass(object, new ReflectTest());
        System.out.println(object);
    }

    public static void invokerPerformance() throws Throwable {
        final Object object = new Object();

        long start = System.nanoTime();

        final MethodHandle handle = Invoker.findVirtual(Object.class, "hashCode", MethodType.methodType(int.class));

        for (int i = 0; i < iterations; i++) {
            int code = (int) handle.invokeExact(object);
        }

        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();

        final Method method = Object.class.getMethod("hashCode");

        for (int i = 0; i < iterations; i++) {
            int code = (int) method.invoke(object);
        }

        System.out.println(System.nanoTime() - start);
    }

    public static void tes() throws Throwable {
        Unsafe.putBoolean(Unsafe.allocateInstance(Field.class), Fields.overrideOffset, true);
    }

    public static void normalFieldTime() {
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

    public static void reflectFieldTime() {
        final ThrowingRunnable test = () -> Fields.getField(TestObject.class, "integer");

        time(test);
        time(test);
        time(test);
        time(test);
        time(test);
    }

    public static void testCopy() {
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

    public static void test() throws Throwable {
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

    public static void logFields(final Object object) {
        for (final Field field : Fields.getInstanceFields(object.getClass())) {
            System.out.printf("%s: %s\n", field, Accessor.getObject(object, field));
        }
    }

    public static void timeN(final ThrowingRunnable test) {
        try {
            final long start = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            Logger.log((System.nanoTime() - start) / (double) iterations);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void timeN(final String label, final ThrowingRunnable test) {
        try {
            final long start = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            Logger.log("%s: %s", label, (System.nanoTime() - start) / (double) iterations);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void time(final ThrowingRunnable test) {
        try {
            final long start = System.nanoTime();

            test.run();

            Logger.log(System.nanoTime() - start);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void time(final String label, final ThrowingRunnable test) {
        try {
            final long start = System.nanoTime();

            test.run();

            Logger.log("%s: %s", label, System.nanoTime() - start);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        Classes.load(true,
            "user11681.reflect.Reflect",
            "user11681.reflect.Invoker",
            "user11681.reflect.Fields",
            "user11681.reflect.Accessor",
            "user11681.reflect.Methods"
        );
    }
}
