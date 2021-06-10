package user11681.reflect.generator;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import user11681.reflect.Classes;
import user11681.reflect.Invoker;
import user11681.reflect.Methods;
import user11681.reflect.generator.base.method.expression.Invocation;

public class UnsafeBuilder extends TestBuilder {
    public UnsafeBuilder() {
        super("user11681.unsafe.Unsafe");

        this.pub();
    }

    @Override
    @Test
    protected void all() throws Throwable {
        super.all();
    }

    @Test
    void generate() {
        Class<Object> type = Classes.load("jdk.internal.misc.Unsafe");

        for (Method unsafeMethod : Methods.getMethods(type)) {
            if (Modifier.isPublic(unsafeMethod.getModifiers()) && !Modifier.isStatic(unsafeMethod.getModifiers())) {
                this.method(method -> method.inherit(unsafeMethod));

                MethodHandle handle = Invoker.unreflectSpecial(unsafeMethod, type);

                this.field(field -> field.type(MethodHandle.class).name(unsafeMethod.getName()).initialize(new Invocation(Invoker.class, "bind")));
            }
        }
    }

    @Override
    @AfterEach
    protected void tearDown() {
        super.tearDown();
    }
}
