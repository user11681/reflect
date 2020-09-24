package user11681.reflect;

import java.io.InputStream;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

@Testable
class ReflectTest {
    static final Logger logger = LoggerFactory.getLogger(ReflectTest.class);

    @Test
    void test() throws Throwable {
        final InputStream stream = ReflectTest.class.getResourceAsStream("/user11681/reflect/ReflectTest$T.class");
        final byte[] bytecode = new byte[stream.available()];

        while (stream.read(bytecode) != -1) {}

        final Class<T> klass = Reflect.defineClass((ClassLoader) Reflect.getObject(ReflectTest.class, Reflect.getField(Class.class, "classLoader")), "user11681.reflect.ReflectTest$T", bytecode);
        final Object t = Unsafe.allocateInstance(klass);

        logger.info(() -> String.valueOf(Reflect.getInt(t, Reflect.getField(klass, "thing"))));

        Reflect.putInt(t, Reflect.getField(klass, "thing"), 12222);

        logger.info(() -> String.valueOf(Reflect.getInt(t, Reflect.getField(klass, "thing"))));
    }

    static class T {
        private final int thing = 1;
    }
}
