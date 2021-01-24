package user11681.reflect.generator;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import user11681.reflect.Classes;
import user11681.reflect.Methods;

@Testable
public class ConstantPoolGenerator extends ClassGenerator {
    public ConstantPoolGenerator() {
        super("src/test/java/ConstantPool.java", "user11681.reflect", "ConstantPool");
    }

    @Test
    public void generate() {
        this.imports("java.lang.invoke.MethodHandle");

        for (Method method : Methods.getMethods(Classes.ConstantPool)) {
            if ((method.getModifiers() & Modifier.NATIVE) == 0) {
                this.methodHandle("Classes.ConstantPool", method);
            }
        }

        this.write();
    }
}
