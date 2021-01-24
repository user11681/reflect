package user11681.reflect;

import java.io.File;
import java.lang.annotation.RetentionPolicy;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.openjdk.jol.info.ClassData;
import user11681.reflect.experimental.Classes2;
import user11681.reflect.experimental.Lists;
import user11681.reflect.experimental.generics.Generics;
import user11681.reflect.experimental.generics.TypeArgument;
import user11681.reflect.generics.GenericTypeAware;
import user11681.reflect.generics.GenericTypeAwareTest;
import user11681.reflect.other.A;
import user11681.reflect.other.C;
import user11681.reflect.other.Enumeration;
import user11681.reflect.other.TestObject;
import user11681.reflect.util.Logger;
import user11681.reflect.util.ThrowingRunnable;

@Testable
public class ReflectTest {
    private static final int iterations = 10000;
    private static final int tests = 10;

    private static final List<Object> dummy = Lists.wrap(new Object[]{0});
    private static int dummyIndex;

    public static Object nul;

    public static <T, R> R var(T object, Function<T, R> function) {
        return function.apply(object);
    }

    public static <T> void var(T object, Consumer<T> consumer) {
        consumer.accept(object);
    }

    public static <T extends Enum<T>> T valueOf(Class<?> klass, String name) {
        return Enum.valueOf((Class<T>) klass, name);
    }

    static {
        RetentionPolicy source = valueOf(RetentionPolicy.class, "SOURCE");
    }

    static {
        var(new Object() {
            Object field0 = "field0";
            Object field1 = "field1";
        }, object -> {
            object.field0 = "new0";
            object.field1 = "new1";
        });
    }

    @Test
    public void castPerformance() {
        timeN("checkcast", () -> {ReflectTest test = (ReflectTest) (Object) (nul);});
        timeN("Class#cast", () -> {ReflectTest test = ReflectTest.class.cast(nul);});
    }

    @Test
    public void genericMetadata() {
        Type[] interfaces = GenericTypeAwareTest.class.getGenericInterfaces();
        Type superclass = GenericTypeAwareTest.class.getGenericSuperclass();
        Type[] parameters = GenericTypeAware.class.getTypeParameters();
        List<TypeArgument> typeArguments = Generics.typeArguments(GenericTypeAwareTest.Sub.Sub1.class);

        boolean bp = true;
    }

    @Test
    public void genericTypeAware() {
        GenericTypeAwareTest typeAware = new GenericTypeAwareTest();

        Logger.log(typeAware.type);
    }

    @Test
    public void changeLoader() {
        Class<?> PackagePrivate = Classes.defineBootstrapClass(ReflectTest.class.getClassLoader(), "user11681/reflect/PackagePrivate");
        assert PackagePrivate.getClassLoader() == null;

        Accessor.putObject((Object) PackagePrivate, "classLoader", Reflect.defaultClassLoader);
        assert PackagePrivate.getClassLoader() == Reflect.defaultClassLoader;

//        Classes.load("user11681.reflect.Public");
    }

    @Test
    public void accessFlags() {
        Class<?> klass = ReflectTest.class;
        ClassData data = ClassData.parseInstance(klass);

        boolean bp = true;
    }

    @Test
    public void multipleInheritance() {
        long IntegerPointer = Classes.getClassPointer(Integer.class) & 0xFFFFFFFFL;
        long StringPointer = Classes.getClassPointer(String.class) & 0xFFFFFFFFL;

        Unsafe.putAddress(IntegerPointer + 4 * 19, StringPointer);

        String string = (String) (Object) 0;
    }

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
    public void lists() {
        Integer[] array = new Integer[100];
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

    @Test
    public void fixedArity() throws Throwable {
        MethodHandle handle = Invoker.bind(new C(), "print", void.class);

        repeat(handle::invokeExact);

        timeN("normal", handle::invokeExact);
        timeN("fixed arity", handle.asFixedArity()::invokeExact);
    }

    @Test
    public void invokeExact() throws Throwable {
        C c = new C();
        MethodHandle handle = Invoker.findSpecial(A.class, "print", void.class);

        handle.invoke(c);
        handle.invokeExact(c);

        handle = handle.bindTo(c);

        handle.invoke();
        handle.invokeExact();
    }

    @Test
    public void cloneTest() {
        A a = new A();

        timeN("clone", a::clone);
        timeN("copy <init>", () -> new A(a));
    }

    @Test
    public void pointer() {
        Enumeration enumeration = EnumConstructor.add(Enumeration.class, 0, "DDD", 4026D);
        Pointer pointer = new Pointer().bind(enumeration).instanceField("test");

        repeat(() -> {
            pointer.putDouble(pointer.getDouble() + 4);
            System.out.println(pointer.getDouble());
        });
    }

    @Test
    public void enumTest() throws Throwable {
        Constructor<?> retentionPolicyConstructor = EnumConstructor.findConstructor(false, RetentionPolicy.class);
        Constructor<?> enumerationConstructor = EnumConstructor.findConstructor(true, Enumeration.class, 0D);

        EnumConstructor.newInstance(Enumeration.class, "TEST", 1D);
        EnumConstructor.newInstance(Enumeration.class, 0, "TEST", 3D);
        EnumConstructor.newInstance(false, Enumeration.class, "TEST", 4D);
        EnumConstructor.newInstance(false, Enumeration.class, 1, "TEST", 5D);

        Enumeration enumeration = EnumConstructor.newInstance(Enumeration.class, 2, "TEST", 2D);
        assert enumeration != null;

        EnumConstructor.add(Enumeration.class, "TEST", 1D);
        EnumConstructor.add(Enumeration.class, 0, "TEST", 3D);
        EnumConstructor.add(false, Enumeration.class, "TEST", 4D);
        EnumConstructor.add(false, Enumeration.class, 1, "TEST", 5D);
        EnumConstructor.add(Enumeration.class, enumeration);

        EnumConstructor<RetentionPolicy> constructor = new EnumConstructor<>(RetentionPolicy.class);

        repeat(() -> constructor.add("TEST", 0D));

        Enumeration.valueOf("TEST");
    }

    @Test
    public void staticCast() {
        Integer a = Classes.staticCast(A.class, Integer.class);

        System.out.println(a);
        System.out.println(A.class.getClassLoader());

        Double dubble = 0D;
        Long longg = Classes.staticCast(dubble, Long.class);

        System.out.println(dubble);
        Accessor.putLong(longg, "value", 0xFFFFFFFFFFL);
        System.out.println(longg);
        System.out.println(Classes.staticCast(longg, Double.class));

        Classes.staticCast(A.class, (Object) Class.class);
    }

    @Test
    public void newInvokerUnreflectTest() {
//        timeN("new", () -> Invoker.unreflect2(A.class, "privateMethod"));

        timeN("old", () -> Invoker.unreflect(A.class, "privateMethod"));
    }

    @Test
    public void invokerOverload() throws Throwable {
        Logger.log(Invoker.unreflect(Boolean.class, "getBoolean", String.class).invoke("123"));
        Logger.log(Invoker.unreflectConstructor(Boolean.class, boolean.class).invoke(true));
    }

    @Test
    public void addClass() {
        Classes2.addClass(String.class, Integer.class);

        String integer = (String) (Object) 0;
        Integer string = (Integer) (Object) "";
    }

    @Test
    public void allFields() {
        for (Field field : Fields.getAllFields(C.class)) {
            Logger.log(field);
        }
    }

    @Test
    public void unreflectTest() throws Throwable {
        Method method = Methods.getMethod(A.class, "privateMethod");
        Method declaredMethod = A.class.getDeclaredMethod("privateMethod");
        MethodHandle methodHandle = Invoker.findStatic(A.class, "privateMethod", String.class);
        MethodHandle unreflected = Invoker.unreflect(method);

        timeN("Method 0", () -> {
            Methods.getMethod(A.class, "privateMethod2", int.class);
        });

        timeN("Method 1", () -> {
            Methods.getMethod(A.class, "privateMethod");
        });

        timeN("Method 2", () -> {
            Method method1 = A.class.getDeclaredMethod("privateMethod");

            method.setAccessible(true);
        });

        timeN("MethodHandle unreflection", () -> {
            Invoker.unreflect(declaredMethod);
        });

        timeN("MethodHandle", () -> {
            Invoker.findStatic(A.class, "privateMethod", String.class);
        });
    }

    @Test
    public void methodTest() {
        timeN(() -> Methods.getMethods(TestObject.class));
        timeN(ReflectTest.class::getDeclaredMethods);
    }

    @Test
    public void classPointerTest() {
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

    @Test
    public void invokerPerformance() throws Throwable {
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
    public void normalFieldTime() {
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
    public void reflectFieldTime() {
        repeat(() -> Fields.getRawFields(TestObject.class));

        time("cached", () -> repeat(() -> Fields.getFields(TestObject.class)));
        time("raw", () -> repeat(() -> Fields.getRawFields(TestObject.class)));
    }

    @Test
    public void testCopy() {
        Field[] fields = Fields.getInstanceFields(ReflectTest.class);
        TestObject one = new TestObject();
        TestObject two = new TestObject();

        logFields(one);

        System.out.println();
        System.out.println();
        System.out.println();

        logFields(two);

        System.out.println();
        System.out.println();
        System.out.println();

        for (Method method : Accessor.class.getDeclaredMethods()) {
            String name = method.getName();

            if (name.startsWith("copy")) {
                String typeName = name.substring(name.indexOf('y') + 1).toLowerCase();

                for (Field field : fields) {
                    String fieldTypeName = field.getType().getSimpleName().toLowerCase();

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
    public void classPath() throws Throwable {
        Object classPath = Classes.getClassPath(ReflectTest.class.getClassLoader());
        File file = new File("test");

        for (URL url : Classes.getURLs(classPath)) {
            Logger.log(url);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        Classes.addURL(classPath, file.toURL());

        for (URL url : Classes.getURLs(classPath)) {
            Logger.log(url);
        }
    }

    @Test
    public <T> T invokeStatic(Class<?> klass, String name, MethodType methodType, Object... arguments) throws Throwable {
        return (T) Unsafe.trustedLookup.findStatic(klass, name, methodType).invokeWithArguments(arguments);
    }

    @Test
    public void logFields(Object object) {
        for (Field field : Fields.getInstanceFields(object.getClass())) {
            System.out.printf("%s: %s\n", field, Accessor.getObject(object, field));
        }
    }

    @Test
    public double timeN(ThrowingRunnable test) {
        try {
            long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            double duration = (double) (System.nanoTime() - time) / iterations;

            Logger.log(duration);

            return duration;
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    @Test
    public double timeN(String label, ThrowingRunnable test) {
        try {
            long time = System.nanoTime();

            for (int i = 0; i < iterations; i++) {
                test.run();
            }

            double duration = (double) (System.nanoTime() - time) / iterations;

            Logger.log("%s: %s", label, duration);

            return duration;
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static long time(ThrowingRunnable test) {
        try {
            long time = System.nanoTime();

            test.run();

            time = System.nanoTime() - time;

            Logger.log(time);

            return time;
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static long time(String label, ThrowingRunnable test) {
        try {
            long time = System.nanoTime();

            test.run();

            time = System.nanoTime() - time;

            Logger.log("%s: %s", label, time);

            return time;
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    @Test
    public void repeat(ThrowingRunnable test) {
        for (int i = 0; i < iterations; i++) {
            try {
                test.run();
            } catch (Throwable throwable) {
                throw Unsafe.throwException(throwable);
            }
        }
    }

    static {
        System.setProperty("jol.tryWithSudo", "true");

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
