package user11681.reflect.generics;

import java.lang.annotation.Retention;

public class GenericTypeAwareTest<E> extends GenericTypeAware<Retention> {
    public static class Sub<E> extends GenericTypeAwareTest<E> {
        public static class Sub1 extends Sub<Object> {}
    }
}
