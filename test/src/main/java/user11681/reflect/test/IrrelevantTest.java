package user11681.reflect.test;

import java.util.function.Consumer;
import java.util.function.Function;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassData;
import user11681.reflect.Classes;
import user11681.reflect.ReflectTest;
import user11681.reflect.util.Util;

public class IrrelevantTest {
    public static <T, R> R var(T object, Function<T, R> function) {
        return function.apply(object);
    }

    public static <T> void var(T object, Consumer<T> consumer) {
        consumer.accept(object);
    }

    @Test
    public void accessFlags() {
        Class<?> klass = ReflectTest.class;
        ClassData data = ClassData.parseInstance(klass);

        Util.bp();
    }

    @Test
    public void multipleInheritance() {
        long IntegerPointer = Classes.getClassPointer(Integer.class) & 0xFFFFFFFFL;
        long StringPointer = Classes.getClassPointer(String.class) & 0xFFFFFFFFL;

        Unsafe.putAddress(IntegerPointer + 4 * 19, StringPointer);

        String string = (String) (Object) 0;
    }

    static {
        var(new Object() {
            Object field0 = "field0";
            Object field1 = "field1";
        }, Object -> {
            Object.field0 = "new0";
            Object.field1 = "new1";
        });
    }
}
