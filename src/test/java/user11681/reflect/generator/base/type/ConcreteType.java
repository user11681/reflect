package user11681.reflect.generator.base.type;

import java.util.Objects;

public record ConcreteType(Class<?> type) implements Type {
    public static final ConcreteType voidType = new ConcreteType(void.class);

    public ConcreteType {
        Objects.requireNonNull(type, "type must not be null");
    }

    @Override
    public String simpleName() {
        return this.type.getSimpleName();
    }
}
