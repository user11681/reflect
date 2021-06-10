package user11681.reflect.generator;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import user11681.reflect.Classes;
import user11681.reflect.Methods;
import user11681.reflect.generator.base.method.expression.GetField;

@Testable
public class ConstantPoolBuilder extends TestBuilder {
    private ConstantPoolBuilder() {
        super("user11681.reflect.ConstantPool");

        this.pub();
    }

    @Override
    @Test
    protected void all() throws Throwable {
        super.all();
    }

    @Override
    @AfterEach
    protected void tearDown() {
        super.tearDown();
    }

    @Test
    public void generate() {
        for (Method method : Methods.getMethods(Classes.ConstantPool)) {
            Class<?> returnType = method.getReturnType();

            if (returnType.getModule().isExported(returnType.getPackageName()) && (method.getModifiers() & Modifier.NATIVE) == 0) {
                this.methodHandle(new GetField().of(Classes.class).name("ConstantPool"), method);
            }
        }
    }
}
