package user11681.reflect.generator.base;

import java.lang.reflect.Modifier;
import java.util.stream.IntStream;

public abstract class MemberGenerator<T extends MemberGenerator<T>> {
    protected int access;
    protected String name;

    public T pub() {
        return this.access(Modifier.PUBLIC);
    }

    public T pro() {
        return this.access(Modifier.PROTECTED);
    }

    public T pri() {
        return this.access(Modifier.PRIVATE);
    }

    public T statik() {
        return this.access(Modifier.STATIC);
    }

    public T access(int... access) {
        this.access |= IntStream.of(access).reduce(0, (left, right) -> left | right);

        return (T) this;
    }

    public String name() {
        return this.name;
    }

    public T name(String name) {
        this.name = name;

        return (T) this;
    }
}
