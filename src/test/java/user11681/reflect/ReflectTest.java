package user11681.reflect;

import java.io.File;
import java.lang.annotation.RetentionPolicy;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import user11681.reflect.experimental.Lists;
import user11681.reflect.misc.A;
import user11681.reflect.misc.C;
import user11681.reflect.misc.Enumeration;
import user11681.reflect.misc.TestObject;
import user11681.reflect.util.Logger;
import user11681.reflect.util.Util;
import user11681.uncheck.Uncheck;

@SuppressWarnings("AssertWithSideEffects")
@Testable
public class ReflectTest {
    private static final List<Object> dummy = Lists.wrap(new Object[]{0});

    @Test
    public void changeLoader() {
        Class<?> PackagePrivate = Classes.defineBootstrapClass(ReflectTest.class.getClassLoader(), "user11681/reflect/misc/PackagePrivate");
        assert PackagePrivate.getClassLoader() == null;

        Accessor.putObject((Object) PackagePrivate, "classLoader", Reflect.defaultClassLoader);
        assert PackagePrivate.getClassLoader() == Reflect.defaultClassLoader;
    }

    @Test
    public void constantPool() {
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
    public void invokeExact() throws Throwable {
        C c = new C();
        MethodHandle handle = Invoker.findSpecial(A.class, "print", void.class);

        handle.invoke(c);
        handle.invokeExact((A) c);

        handle = handle.bindTo(c);

        handle.invoke();
        handle.invokeExact();
    }

    @SuppressWarnings("WrapperTypeMayBePrimitive")
    @Test
    public void pointer() {
        A a = new A();
        a.yes = 446;
        Double yes = a.yes;

        Pointer pointer = new Pointer().bind(a).instanceField("yes");

        Util.repeat(() -> {
            pointer.putDouble(pointer.getDouble() + 4);

            Accessor.putDouble(yes, "value", yes + 4);

            assert yes == pointer.getDouble();
        });
    }

    @Test
    public void enumeration() {
        Constructor<?> retentionPolicyConstructor = EnumConstructor.findConstructor(false, RetentionPolicy.class);
        Constructor<?> enumerationConstructor = EnumConstructor.findConstructor(true, Enumeration.class, 0D);

        assert EnumConstructor.newInstance(Enumeration.class, "TEST", 1D).ordinal() == 0;
        assert EnumConstructor.newInstance(Enumeration.class, 0, "TEST", 553D).test == 553;
        assert EnumConstructor.newInstance(false, Enumeration.class, "TEST", 4D).test == 4;
        assert EnumConstructor.newInstance(false, Enumeration.class, 1, "TEST", 9023D).test == 9023;

        Enumeration enumeration = EnumConstructor.newInstance(Enumeration.class, 2, "TEST", 2D);
        assert enumeration != null && enumeration.test == 2;

        var expectedLength = new Object() {
            int length = 0;
        };

        Runnable verifySize = () -> {
            assert Enumeration.values().length == expectedLength.length++;
        };

        verifySize.run();

        EnumConstructor.add(Enumeration.class, "TEST", 1D);
        verifySize.run();

        EnumConstructor.add(Enumeration.class, 0, "TEST", 3D);
        verifySize.run();

        EnumConstructor.add(false, Enumeration.class, "TEST", 4D);
        verifySize.run();

        EnumConstructor.add(false, Enumeration.class, 1, "TEST", 5D);
        verifySize.run();

        EnumConstructor.add(Enumeration.class, enumeration);
        verifySize.run();

        EnumConstructor<RetentionPolicy> constructor = new EnumConstructor<>(RetentionPolicy.class);

        Util.repeat(() -> constructor.add("TEST", 0D));

        Enumeration.valueOf("TEST");
    }

    @Test
    public void staticCast() {
        Integer a = Classes.reinterpret(A.class, Integer.class);

        System.out.println(a);
        System.out.println(A.class.getClassLoader());

        Double dubble = 0D;
        Long longg = Classes.reinterpret(dubble, Long.class);

        System.out.println(dubble);
        Accessor.putLong(longg, "value", 0xFFFFFFFFFFL);
        System.out.println(longg);
        System.out.println(Classes.reinterpret(longg, Double.class));

        Classes.reinterpret(A.class, (Object) Class.class);
    }

    @Test
    public void invokerOverload() throws Throwable {
        Logger.log(Invoker.unreflect(Boolean.class, "getBoolean", String.class).invoke("123"));
        Logger.log(Invoker.unreflectConstructor(Boolean.class, boolean.class).invoke(true));
    }

    @Test
    public void allFields() {
        for (Field field : Fields.getAllFields(C.class)) {
            Logger.log(field);
        }
    }

    @Test
    public void classPointer() {
        Object object = Unsafe.allocateInstance(Object.class);

        System.out.println(object);
        Classes.reinterpret(object, ReflectTest.class);
        System.out.println(object);

        object = Unsafe.allocateInstance(ReflectTest.class);

        System.out.println(object);
        Classes.reinterpret(object, ReflectTest.class);
        System.out.println(object);

        object = Unsafe.allocateInstance(Object.class);

        System.out.println(object);
        Classes.reinterpret(object, new ReflectTest());
        System.out.println(object);
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
        Object classPath = Classes.classPath(ReflectTest.class.getClassLoader());
        File file = new File("test");

        for (URL url : Classes.urls(classPath)) {
            Logger.log(url);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        Classes.addURL(classPath, file.toURI().toURL());

        for (URL url : Classes.urls(classPath)) {
            Logger.log(url);
        }
    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    @Test
    void constructor() throws Throwable {
        class PrivateCtor {
            public final int test;

            private PrivateCtor(int test) {
                this.test = test;
            }
        }

        Constructor<PrivateCtor> constructor = PrivateCtor.class.getDeclaredConstructor(ReflectTest.class, int.class);

        assert Arrays.equals(Constructors.constructors(PrivateCtor.class), new Constructor[]{constructor});
        assert Constructors.constructor(PrivateCtor.class, ReflectTest.class, int.class).newInstance(this, 4).test == 4;
        assert Constructors.construct(PrivateCtor.class, this, 27).test == 27;
    }

    @Test
    void method() {
        assert Constructors.constructor(false, Enumeration.class, "", 1, 4D) == null;
        assert Constructors.constructor(true, Enumeration.class, "", 1, 4D) != null;
    }

    @Test
    void invoke() {
        Runnable runnable = () -> {};
        Function<Integer, String> function = String::valueOf;
        IntFunction<Integer> consumer = Integer::valueOf;

        Invoker.run(Invoker.bind(runnable, "run", void.class));

        assert "123".equals(Invoker.apply(Invoker.bind(function, "apply", Object.class, Object.class), 123));
        assert (Integer) Invoker.apply(Invoker.bind(consumer, "apply", Object.class, int.class), 57) == 57;
    }

    public void logFields(Object object) {
        Uncheck.handle(() -> {
            for (Field field : Fields.getInstanceFields(object.getClass())) {
                System.out.printf("%s: %s\n", field, field.get(object));
            }
        });
    }

    static {
        System.setProperty("jol.tryWithSudo", "true");
    }
}
