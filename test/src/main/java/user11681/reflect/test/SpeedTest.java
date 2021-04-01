package user11681.reflect.test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import user11681.reflect.Classes;
import user11681.reflect.Fields;
import user11681.reflect.Invoker;
import user11681.reflect.Methods;
import user11681.reflect.Reflect;
import user11681.reflect.ReflectTest;
import user11681.reflect.experimental.Lists;
import user11681.reflect.misc.A;
import user11681.reflect.misc.C;
import user11681.reflect.misc.TestObject;
import user11681.reflect.util.Logger;
import user11681.reflect.util.Util;
import user11681.uncheck.ThrowingRunnable;
import user11681.uncheck.Uncheck;

@SuppressWarnings("UnusedReturnValue")
public class SpeedTest {
    static final int iterations = 10000;
    static final int tests = 10;
    static Runnable runnable0;
    static Runnable runnable1;

    @Test
    static double timeN(ThrowingRunnable test) {
        return Uncheck.handle(() -> {
            long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            double duration = (double) (System.nanoTime() - time) / iterations;

            Logger.log(duration);

            return duration;
        });
    }

    static double timeN(String label, ThrowingRunnable test) {
        return Uncheck.handle(() ->  {
            long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            double duration = (double) (System.nanoTime() - time) / iterations;

            Logger.log("%s: %s", label, duration);

            return duration;
        });
    }

    static long time(ThrowingRunnable test) {
        return Uncheck.handle(() -> {
            long time = System.nanoTime();

            test.run();

            time = System.nanoTime() - time;

            Logger.log(time);

            return time;
        });
    }

    static long time(String label, ThrowingRunnable test) {
        return Uncheck.handle(() -> {
            long time = System.nanoTime();

            test.run();

            time = System.nanoTime() - time;

            Logger.log("%s: %s", label, time);

            return time;
        });
    }

    @Test
    void invoker() throws Throwable {
        Object object = new Object();

        long start = System.nanoTime();

        MethodHandle handle = Invoker.findVirtual(Object.class, "hashCode", MethodType.methodType(int.class));

        for (int i = 0; i < iterations; i++) {
            int code = (int) handle.invokeExact(object);
        }

        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();

        Method method = Object.class.getMethod("hashCode");

        for (int i = 0; i < iterations; i++) {
            int code = (int) method.invoke(object);
        }

        System.out.println(System.nanoTime() - start);
    }

    @Test
    void normalField() {
        ThrowingRunnable test = () -> {
            Field field = TestObject.class.getDeclaredField("integer");

            field.setAccessible(true);

            Field modifiers = Field.class.getDeclaredField("modifiers");

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
    void reflectField() {
        Util.repeat(() -> Fields.getRawFields(TestObject.class));

        time("cached", () -> Util.repeat(() -> Fields.getFields(TestObject.class)));
        time("raw", () -> Util.repeat(() -> Fields.getRawFields(TestObject.class)));
    }

    @Test
    void lists() {
        Integer[] array = new Integer[100];
        Arrays.fill(array, 0, array.length, 29);

        timeN("ArrayList constructor", () -> new ArrayList<>(Arrays.asList(array)));
        timeN("Unsafe", () -> Lists.wrap(new ArrayList<>(), array, 100));

        timeN("ArrayList addAll", () -> new ArrayList<>().addAll(Arrays.asList(array)));
        timeN("Unsafe", () -> Lists.addAll(new ArrayList<>(), array));
    }

    @Test
    void instantiation() {
        timeN("constructor", () -> new ArrayList<>());
        timeN("Unsafe", () -> Unsafe.allocateInstance(ArrayList.class));
    }

    @Test
    void fixedArity() {
        MethodHandle handle = Invoker.bind(new C(), "print", void.class);

        Util.repeat(handle::invokeExact);

        timeN("normal", handle::invokeExact);
        timeN("fixed arity", handle.asFixedArity()::invokeExact);
    }

    @Test
    void clon() {
        A a = new A();

        timeN("clone", a::clone);
        timeN("copy <init>", () -> new A(a));
    }

    @Test
    public void unreflect() throws Throwable {
        Method method = Methods.getMethod(A.class, "privateMethod");
        Method declaredMethod = A.class.getDeclaredMethod("privateMethod");
        MethodHandle methodHandle = Invoker.findStatic(A.class, "privateMethod", String.class);
        MethodHandle unreflected = Invoker.unreflect(method);

        timeN("Method 0", () -> Methods.getMethod(A.class, "privateMethod2", int.class));

        timeN("Method 1", () -> Methods.getMethod(A.class, "privateMethod"));

        timeN("Method 2", () -> {
            Method method1 = A.class.getDeclaredMethod("privateMethod");

            method.setAccessible(true);
        });

        timeN("MethodHandle unreflection", () -> Invoker.unreflect(declaredMethod));

        timeN("MethodHandle", () -> Invoker.findStatic(A.class, "privateMethod", String.class));
    }

    @Test
    public void newInvokerUnreflect() {
        //        timeN("new", () -> Invoker.unreflect2(A.class, "privateMethod"));

        timeN("old", () -> Invoker.unreflect(A.class, "privateMethod"));
    }

    @Test
    public void method() {
        timeN(() -> Methods.getMethods(TestObject.class));
        timeN(ReflectTest.class::getDeclaredMethods);
    }

    @SuppressWarnings("Convert2Lambda")
    @Test
    void lambda() {
        time("anonymous class", () -> runnable0 = new Runnable() {
            @Override
            public void run() {}
        });

        time("lambda", () -> runnable1 = () -> {});
    }

    @Test
    public void cast() {
        timeN("checkcast", () -> {ReflectTest test = Util.nul();});
        timeN("Class#cast", () -> {ReflectTest test = ReflectTest.class.cast(Util.nul());});
    }

    static {
        long time = time(() -> Classes.load(true, "user11681.reflect.Reflect"));

        try (Stream<Path> classStream = Files.list(Paths.get(Reflect.class.getProtectionDomain().getCodeSource().getLocation().toURI()).resolve("user11681/reflect"))) {
            List<Path> classes = classStream.collect(Collectors.toList());

            time += time(() -> {
                for (Path klass : classes) {
                    Class.forName("user11681.reflect." + klass.getFileName().toString().replace(".class", ""));
                }
            });

            Logger.log("initialized in %s ms", time / 1000000D);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
