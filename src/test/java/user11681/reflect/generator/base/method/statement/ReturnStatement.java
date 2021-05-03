package user11681.reflect.generator.base.method.statement;

import user11681.reflect.generator.base.method.expression.Expression;

public record ReturnStatement(Expression expression) implements Statement {
    @Override
    public String toString() {
        return "return " + this.expression + ';';
    }
}
