package user11681.reflect.test;

import java.lang.annotation.RetentionPolicy;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

@SuppressWarnings("ALL")
public class SpeedTest {
    static final int iterations = 3;
    static final int tests = 1;
    static Runnable runnable0;
    static Runnable runnable1;

    static long mean(ThrowingRunnable test) {
        return mean(true, null, test);
    }

    static long mean(String label, ThrowingRunnable test) {
        return mean(true, label, test);
    }

    static long mean(boolean loud, String label, ThrowingRunnable test) {
        return Uncheck.handle(() -> {
            long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            long duration = Math.round((double) (System.nanoTime() - time) / iterations);

            if (loud) {
                if (label == null) {
                    Logger.log(duration);
                } else Logger.log("%s: %s", label, duration);
            }

            return duration;
        });
    }

    static long time(ThrowingRunnable test) {
        return time(true, null, test);
    }

    static long time(String label, ThrowingRunnable test) {
        return time(true, label, test);
    }

    static long time(boolean loud, ThrowingRunnable test) {
        return time(loud, null, test);
    }

    static long time(boolean loud, String label, ThrowingRunnable test) {
        return Uncheck.handle(() -> {
            long time = System.nanoTime();

            test.run();

            time = System.nanoTime() - time;

            if (loud) {
                if (label == null) {
                    Logger.log(time);
                } else Logger.log("%s: %s", label, time);
            }

            return time;
        });
    }

    static long total(ThrowingRunnable test) {
        return total(true, null, test);
    }

    static long total(String label, ThrowingRunnable test) {
        return total(true, label, test);
    }

    static long total(boolean loud, ThrowingRunnable test) {
        return total(loud, null, test);
    }

    static long total(boolean loud, String label, ThrowingRunnable test) {
        return Uncheck.handle(() -> {
            long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            time = System.nanoTime() - time;

            if (loud) {
                if (label == null) {
                    Logger.log(time);
                } else Logger.log("%s: %s", label, time);
            }

            return time;
        });
    }

    @Test
    void invoker() throws Throwable {
        Object object = new Object();

        long start = System.nanoTime();

        MethodHandle handle = Invoker.findVirtual(Object.class, "hashCode", int.class);

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

        mean("ArrayList constructor", () -> new ArrayList<>(Arrays.asList(array)));
        mean("Unsafe", () -> Lists.wrap(new ArrayList<>(), array, 100));

        mean("ArrayList addAll", () -> new ArrayList<>().addAll(Arrays.asList(array)));
        mean("Unsafe", () -> Lists.addAll(new ArrayList<>(), array));
    }

    @Test
    void instantiation() {
        mean("constructor", () -> new ArrayList<>());
        mean("Unsafe", () -> Unsafe.allocateInstance(ArrayList.class));
    }

    @Test
    void fixedArity() {
        MethodHandle handle = Invoker.bind(new C(), "print", void.class);

        Util.repeat(handle::invokeExact);

        mean("normal", handle::invokeExact);
        mean("fixed arity", handle.asFixedArity()::invokeExact);
    }

    @Test
    void clon() {
        A a = new A();

        mean("clone", a::clone);
        mean("copy <init>", () -> new A(a));
    }

    @Test
    public void unreflect() throws Throwable {
        Method method = Methods.getMethod(A.class, "privateMethod");
        Method declaredMethod = A.class.getDeclaredMethod("privateMethod");
        MethodHandle methodHandle = Invoker.findStatic(A.class, "privateMethod", String.class);
        MethodHandle unreflected = Invoker.unreflect(method);

        mean("Method 0", () -> Methods.getMethod(A.class, "privateMethod2", int.class));

        mean("Method 1", () -> Methods.getMethod(A.class, "privateMethod"));

        mean("Method 2", () -> {
            Method method1 = A.class.getDeclaredMethod("privateMethod");

            method.setAccessible(true);
        });

        mean("MethodHandle unreflection", () -> Invoker.unreflect(declaredMethod));

        mean("MethodHandle", () -> Invoker.findStatic(A.class, "privateMethod", String.class));
    }

    @Test
    public void newInvokerUnreflect() {
        //        timeN("new", () -> Invoker.unreflect2(A.class, "privateMethod"));

        mean("old", () -> Invoker.unreflect(A.class, "privateMethod"));
    }

    @Test
    public void method() {
        mean(() -> Methods.getMethods(TestObject.class));
        mean(ReflectTest.class::getDeclaredMethods);
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
        mean("checkcast", () -> {ReflectTest test = Util.nul();});
        mean("Class#cast", () -> {ReflectTest test = ReflectTest.class.cast(Util.nul());});
    }

    @Test
    void enumConstruction() throws Throwable {
        MethodHandle handle = Invoker.findConstructor(RetentionPolicy.class, String.class, int.class);
        MethodHandle newInstance0 = Invoker.findStatic(Classes.NativeConstructorAccessorImpl, "newInstance0", Object.class, Constructor.class, Object[].class).bindTo(RetentionPolicy.class.getDeclaredConstructor(String.class, int.class));

        Util.repeat(10000, () -> handle.invoke("", 1));

        mean("MethodHandle", () -> handle.invoke("", 1));
        mean("NativeConstructorAccessorImpl", () -> newInstance0.invoke(new Object[]{"", 1}));
    }

    @Test
    void field() {
        Fields.rawFields(String.class);

        long total0 = mean("rawFields 0", () -> Fields.rawFields(String.class))
            + mean("rawFields 1", () -> Fields.rawFields(String.class));

        long total1 = mean("fields uncached", () -> Fields.fields(String.class))
            + mean("fields cached", () -> Fields.fields(String.class));

        Logger.log("total raw: %s", total0);
        Logger.log("total cache: %s", total1);
    }

    static {
        double time = time(false, Reflect.class::getProtectionDomain);

        try (Stream<Path> classStream = Files.list(Paths.get(Reflect.class.getProtectionDomain().getCodeSource().getLocation().toURI()).resolve("user11681/reflect"))) {
            time += classStream.map((Path klass) -> time(false, () -> Class.forName("user11681.reflect." + klass.getFileName().toString().replace(".class", "")))).reduce(0L, Long::sum);

            Logger.log("initialized in %s ms%n", time / 1000000D);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
