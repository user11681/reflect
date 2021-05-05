package user11681.reflect.generator.base.method.expression;

import java.util.stream.Stream;
import user11681.reflect.generator.base.method.Variable;
import user11681.reflect.generator.base.method.statement.AssignmentStatement;
import user11681.reflect.generator.base.method.statement.Statement;
import user11681.reflect.generator.base.type.ConcreteType;

public record StoreVariable(Variable variable, Expression expression) implements StatementExpression {
    @Override
    public Statement statement() {
        return new AssignmentStatement(this);
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.expression.referencedTypes();
    }

    @Override
    public String toString() {
        return "%s = %s".formatted(this.variable.name(), this.expression);
    }
}
