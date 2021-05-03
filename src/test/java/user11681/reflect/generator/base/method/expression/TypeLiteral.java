package user11681.reflect.generator.base.method.expression;

import user11681.reflect.generator.base.type.ConcreteType;

public record TypeLiteral(ConcreteType type) implements Expression {
    public TypeLiteral(Class<?> type) {
        this(new ConcreteType(type));
    }

    @Override
    public String toString() {
        return this.type.simpleName() + ".class";
    }
}
