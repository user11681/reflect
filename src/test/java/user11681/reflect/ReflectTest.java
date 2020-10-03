package user11681.reflect;

import java.io.File;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class ReflectTest {
    static final Logger logger = LogManager.getLogger("test");

    @Test
    void test() throws Throwable {
        final Object classPath = Reflect.getClassPath(ReflectTest.class.getClassLoader());
        final File file = new File("test");

        logger.warn(Arrays.toString(Reflect.getURLs(classPath)));

        Reflect.addURL(classPath, file.toURL());

        logger.warn(Arrays.toString(Reflect.getURLs(classPath)));
    }

    static class T {
        private volatile int thing = 1;
    }
}
