package user11681.reflect.generator.base.method.expression;

import java.util.stream.Stream;
import user11681.reflect.generator.base.type.ConcreteType;

public record TypeLiteral(ConcreteType type) implements Expression, Literal {
    public TypeLiteral(Class<?> type) {
        this(new ConcreteType(type));
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.of(this.type);
    }

    @Override
    public String toString() {
        return this.type + ".class";
    }
}
