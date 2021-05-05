package user11681.reflect.generator.base.method.expression;

import java.util.stream.Stream;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.type.Type;

public record CastExpression(Expression expression, Type type) implements Expression {
    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.type.referencedTypes();
    }

    @Override
    public String toString() {
        return "(%s) %s".formatted(this.type, this.expression);
    }
}
