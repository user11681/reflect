package user11681.reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class ReflectTest {
    static final Logger logger = LogManager.getLogger("test");

    int test;
    int bruh;
    boolean hurb;

    @Test
    void normalFieldTime() {
        final ThrowingRunnable test = () -> {
            final Field field = ReflectTest.class.getDeclaredField("test");

            field.setAccessible(true);

            final Field modifiers = Field.class.getDeclaredField("modifiers");

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
    void reflectFieldTime() {
        final ThrowingRunnable test = () -> Fields.getField(ReflectTest.class, "test");

        time(test);
        time(test);
        time(test);
        time(test);
        time(test);
    }

    @Test
    void test() throws Throwable {
        final Object classPath = Classes.getClassPath(ReflectTest.class.getClassLoader());
        final File file = new File("test");

        for (final URL url : Classes.getURLs(classPath)) {
            logger.warn(url);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        Classes.addURL(classPath, file.toURL());

        for (final URL url : Classes.getURLs(classPath)) {
            logger.warn(url);
        }
    }

    static void time(final ThrowingRunnable test) {
        try {
            final long start = System.nanoTime();

            test.run();

            System.out.println(System.nanoTime() - start);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    static {
        Accessor.putInt((Object) Accessor.getObjectVolatile(logger, "privateConfig"), "intLevel", 600);
    }
}
