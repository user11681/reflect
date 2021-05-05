package user11681.reflect.generator.base.method.statement;

import java.util.stream.Stream;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.type.ConcreteType;

public record Return(Expression expression) implements Statement {
    @Override
    public String toString() {
        return "return " + this.expression + ';';
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.expression.referencedTypes();
    }
}
