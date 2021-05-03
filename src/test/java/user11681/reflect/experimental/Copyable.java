package user11681.reflect.experimental;

import java.lang.invoke.MethodHandle;
import net.gudenau.lib.unsafe.Unsafe;
import user11681.reflect.Invoker;

public interface Copyable<T extends Copyable<T>> extends Cloneable {
    MethodHandle clone = Invoker.findVirtual(Object.class, "clone", Object.class);

    default T copy() {
        try {
            return (T) clone.invoke(this);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
