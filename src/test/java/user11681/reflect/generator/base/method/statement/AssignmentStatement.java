package user11681.reflect.generator.base.method.statement;

import user11681.reflect.generator.base.method.expression.StoreVariable;

public record AssignmentStatement(StoreVariable variable) implements Statement {
    @Override
    public String toString() {
        return this.variable.toString() + ';';
    }
}
