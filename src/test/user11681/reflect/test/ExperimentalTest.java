package user11681.reflect.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import user11681.reflect.Accessor;
import user11681.reflect.Fields;
import user11681.reflect.experimental.ReflectionFactory;
import user11681.reflect.util.Logger;
import user11681.reflect.util.Retainable;
import user11681.reflect.util.Util;

@Testable
public class ExperimentalTest {
    @Retainable
    static long test2 = 0xFF0000000BL;
    static int test = 2;
    static int test1 = 97;
    byte byte0;
    byte byte1;
    float instance = 54.2F;

    @Test
    void trustedFinal() {
        Logger.log(Accessor.get(Fields.field(String.class, "value"), "trustedFinal"));
    }

    @Test
    void factory() {
        Field field = ReflectionFactory.field(ExperimentalTest.class, int.class, Modifier.STATIC, 0);

        assert Accessor.getInt(field) == 0xB;
        assert Accessor.getLong(field) == 0xFF0000000BL;

        field = ReflectionFactory.field(ExperimentalTest.class, int.class, Modifier.STATIC, 1);

        assert Accessor.getInt(field) == 2;

        field = ReflectionFactory.field(ExperimentalTest.class, int.class, Modifier.STATIC, 2);

        assert Accessor.getInt(field) == 97;

        Accessor.put(field, 23);

        assert test1 == 23;

        Util.bp();
    }
}
