package user11681.reflect.generator.base.method.expression.literal;

import user11681.reflect.generator.base.method.expression.Expression;

public record StringLiteral(String string) implements Expression, Literal {
    @Override
    public String toString() {
        return '"' + this.string + '"';
    }
}
