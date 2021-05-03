package user11681.reflect.generator.base.method.statement;

import user11681.reflect.generator.base.method.expression.Invocation;

public record InvocationStatement(Invocation invocation) implements Statement {
    @Override
    public String toString() {
        return this.invocation.toString() + ';';
    }
}
