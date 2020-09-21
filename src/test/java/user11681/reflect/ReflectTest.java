package user11681.reflect;

import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class ReflectTest {
    @Test
    void test() throws Throwable {
        final InputStream stream = ReflectTest.class.getResourceAsStream("/user11681/reflect/ReflectTest$T.class");
        final byte[] bytecode = new byte[stream.available()];

        while (stream.read(bytecode) != -1) {}

        Reflect.defineClass(ReflectTest.class.getClassLoader(), bytecode);
    }

    static class T {}
}
