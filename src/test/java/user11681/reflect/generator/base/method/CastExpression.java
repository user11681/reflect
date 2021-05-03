package user11681.reflect.generator.base.method;

import user11681.reflect.generator.base.type.Type;

public record CastExpression(Expression expression, Type type) implements Expression {
    @Override
    public String toString() {
        return "(%s) %s".formatted(this.type.simpleName(), this.expression);
    }
}
