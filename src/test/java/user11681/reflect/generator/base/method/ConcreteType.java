package user11681.reflect.generator.base.method;

import java.util.Objects;
import user11681.reflect.generator.base.type.Type;

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
