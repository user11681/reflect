package user11681.reflect.generator;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import user11681.reflect.Invoker;
import user11681.reflect.Methods;
import user11681.reflect.generator.base.ClassBuilder;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.expression.Invocation;
import user11681.reflect.generator.base.method.expression.literal.Literal;

public abstract class TestBuilder extends ClassBuilder {
    public TestBuilder(Class<?> klass) {
        super(klass);
    }

    public TestBuilder(String name) {
        super(name);
    }

    public TestBuilder(String pakage, String name) {
        super(pakage, name);
    }

    @Test
    protected void all() throws Throwable {
        for (Method method : Methods.getMethods(this.getClass())) {
            if (method.isAnnotationPresent(Test.class) && !method.getName().equals("all")) {
                method.invoke(this);
            }
        }
    }

    @AfterEach
    protected void tearDown() {
        System.out.println(this);
    }

    protected ClassBuilder methodHandle(Expression klass, Method method) {
        String name;

        if (Modifier.isStatic(method.getModifiers())) {
            name = "findStatic";
        } else if (Modifier.isPrivate(method.getModifiers())) {
            name = "findSpecial";
        } else {
            name = "findVirtual";
        }

        Invocation initializer = new Invocation(Invoker.class, name,
            klass,
            Literal.of(method.getName()),
            Literal.of(method.getReturnType())
        );

        Stream.of(method.getParameterTypes()).map(Literal::of).forEach(initializer::argument);
        this.field(field -> field.type(MethodHandle.class).name(method.getName()).initialize(initializer));

        return this;
    }
}
