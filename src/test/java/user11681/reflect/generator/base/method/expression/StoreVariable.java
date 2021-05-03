package user11681.reflect.generator.base.method.expression;

import user11681.reflect.generator.base.method.Variable;
import user11681.reflect.generator.base.method.statement.AssignmentStatement;
import user11681.reflect.generator.base.method.statement.Statement;

public record StoreVariable(Variable variable, Expression expression) implements StatementExpression {
    @Override
    public String toString() {
        return "%s = %s".formatted(this.variable.name(), this.expression);
    }

    @Override
    public Statement statement() {
        return new AssignmentStatement(this);
    }
}
