package user11681.reflect;

import java.io.File;
import java.lang.annotation.RetentionPolicy;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import user11681.reflect.experimental.Classes2;
import user11681.reflect.experimental.Lists;
import user11681.reflect.other.A;
import user11681.reflect.other.C;
import user11681.reflect.other.Enumeration;
import user11681.reflect.other.TestObject;
import user11681.reflect.util.Logger;
import user11681.reflect.util.ThrowingRunnable;

@Testable
public class ReflectTest {
    private static final int iterations = 56;
    private static final int tests = 10;

    private static final List<Object> dummy = Lists.wrap(new Object[]{0});
    private static int dummyIndex;

    @Test
    public void constantPool() throws Throwable {
        Function<Integer, Integer> lambda = i -> i;
        ConstantPool pool = new ConstantPool(lambda.getClass());
        int size = pool.getSize();

        Logger.log(size);

        for (int i = 0; i < size; i++) {
            Object method = pool.getMethodAt(i);

            if (method != null) {
                Logger.log(method);
            }
        }
    }

    @Test
    public void test() throws Throwable {
        fixedArity();
    }

    @Test
    public void lists() {
        final Integer[] array = new Integer[100];
        Arrays.fill(array, 0, array.length, 29);

        timeN("ArrayList constructor", () -> new ArrayList<>(Arrays.asList(array)));
        timeN("Unsafe", () -> Lists.wrap(new ArrayList<>(), array, 100));

        timeN("ArrayList addAll", () -> new ArrayList<>().addAll(Arrays.asList(array)));
        timeN("Unsafe", () -> Lists.addAll(new ArrayList<>(), array));
    }

    @Test
    public void instantiation() {
        timeN("constructor", () -> new ArrayList<>());
        timeN("Unsafe", () -> Unsafe.allocateInstance(ArrayList.class));
    }

    public static void fixedArity() throws Throwable {
        final MethodHandle handle = Invoker.bind(new C(), "print", void.class);

        repeat(handle::invokeExact);

        timeN("normal", handle::invokeExact);
        timeN("fixed arity", handle.asFixedArity()::invokeExact);
    }

    public static void invokeExact() throws Throwable {
        final C c = new C();
        MethodHandle handle = Invoker.findSpecial(A.class, "print", void.class);

        handle.invoke(c);
        handle.invokeExact(c);

        handle = handle.bindTo(c);

        handle.invoke();
        handle.invokeExact();
    }

    public static void cloneTest() {
        final A a = new A();

        timeN("clone", a::clone);
        timeN("copy <init>", () -> new A(a));
    }

    public static void pointer() {
        final Enumeration enumeration = EnumConstructor.add(Enumeration.class, 0, "DDD", 4026D);
        final Pointer pointer = new Pointer().bind(enumeration).instanceField("test");

        repeat(() -> {
            pointer.putDouble(pointer.getDouble() + 4);
            System.out.println(pointer.getDouble());
        });
    }

    public static void enumTest() throws Throwable {
        final Constructor<?> retentionPolicyConstructor = EnumConstructor.findConstructor(false, RetentionPolicy.class);
        final Constructor<?> enumerationConstructor = EnumConstructor.findConstructor(true, Enumeration.class, 0D);
        EnumConstructor.newInstance(Enumeration.class, "TEST", 1D);
        EnumConstructor.newInstance(Enumeration.class, 0, "TEST", 3D);
        EnumConstructor.newInstance(false, Enumeration.class, "TEST", 4D);
        EnumConstructor.newInstance(false, Enumeration.class, 1, "TEST", 5D);

        final Enumeration enumeration = EnumConstructor.newInstance(Enumeration.class, 2, "TEST", 2D);
        assert enumeration != null;

        EnumConstructor.add(Enumeration.class, "TEST", 1D);
        EnumConstructor.add(Enumeration.class, 0, "TEST", 3D);
        EnumConstructor.add(false, Enumeration.class, "TEST", 4D);
        EnumConstructor.add(false, Enumeration.class, 1, "TEST", 5D);
        EnumConstructor.add(Enumeration.class, enumeration);

        final EnumConstructor<RetentionPolicy> constructor = new EnumConstructor<>(RetentionPolicy.class);

        repeat(() -> constructor.add("TEST", 0D));

        Enumeration.valueOf("TEST");
    }

    public static void staticCast() {
        final Integer a = Classes.staticCast(A.class, Integer.class);

        System.out.println(a);
        System.out.println(A.class.getClassLoader());

        final Double dubble = 0D;
        final Long longg = Classes.staticCast(dubble, Long.class);

        System.out.println(dubble);
        Accessor.putLong(longg, "value", 0xFFFFFFFFFFL);
        System.out.println(longg);
        System.out.println(Classes.staticCast(longg, Double.class));

        Classes.staticCast(A.class, (Object) Class.class);
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
        Classes.staticCast(object, ReflectTest.class);
        System.out.println(object);

        object = Unsafe.allocateInstance(ReflectTest.class);

        System.out.println(object);
        Classes.staticCast(object, ReflectTest.class);
        System.out.println(object);

        object = Unsafe.allocateInstance(Object.class);

        System.out.println(object);
        Classes.staticCast(object, new ReflectTest());
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
        repeat(() -> Fields.getRawFields(TestObject.class));

        time("cached", () -> repeat(() -> Fields.getFields(TestObject.class)));
        time("raw", () -> repeat(() -> Fields.getRawFields(TestObject.class)));
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

    public static void classPath() throws Throwable {
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

    public static double timeN(final ThrowingRunnable test) {
        try {
            final long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            final double duration = (double) (System.nanoTime() - time) / iterations;

            Logger.log(duration);

            return duration;
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static double timeN(final String label, final ThrowingRunnable test) {
        try {
            final long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            final double duration = (double) (System.nanoTime() - time) / iterations;

            Logger.log("%s: %s", label, duration);

            return duration;
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static long time(final ThrowingRunnable test) {
        try {
            long time = System.nanoTime();

            test.run();

            time = System.nanoTime() - time;

            Logger.log(time);

            return time;
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static long time(final String label, final ThrowingRunnable test) {
        try {
            long time = System.nanoTime();

            test.run();

            time = System.nanoTime() - time;

            Logger.log("%s: %s", label, time);

            return time;
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void repeat(final ThrowingRunnable test) {
        for (int i = 0; i < iterations; i++) {
            try {
                test.run();
            } catch (final Throwable throwable) {
                throw Unsafe.throwException(throwable);
            }
        }
    }

    static {
        Classes.load(true,
            "user11681.reflect.Reflect",
            "user11681.reflect.Invoker",
            "user11681.reflect.Fields",
            "user11681.reflect.Accessor",
            "user11681.reflect.Methods",
            "user11681.reflect.EnumConstructor",
            "user11681.reflect.Pointer"
        );
    }
}
