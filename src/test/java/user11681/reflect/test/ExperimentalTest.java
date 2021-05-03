package user11681.reflect.test;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import user11681.reflect.experimental.StackFrames;
import user11681.reflect.util.Util;

@Testable
public class ExperimentalTest {
    @Test
    void caller() throws Throwable {
        Supplier<Class<?>> lambda = StackFrames::caller;

        assert Util.equals(this.getClass(),
            StackFrames.caller(),
            StackFrames.caller(0),
            lambda.get(),
            StackFrames.frames().get(0).getDeclaringClass()
        );
    }
}
