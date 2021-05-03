package user11681.reflect.generator;

import java.lang.reflect.Method;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import user11681.reflect.Methods;
import user11681.reflect.generator.base.ClassGenerator;

public abstract class TestGenerator extends ClassGenerator {
    public TestGenerator(Class<?> klass) {
        super(klass);
    }

    public TestGenerator(String name) {
        super(name);
    }

    public TestGenerator(String pakage, String name) {
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
}
