package user11681.reflect.generator.base.method.statement;

import java.util.stream.Stream;
import user11681.reflect.generator.base.method.expression.StoreVariable;
import user11681.reflect.generator.base.type.ConcreteType;

public record AssignmentStatement(StoreVariable variable) implements Statement {
    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.variable.referencedTypes();
    }

    @Override
    public String toString() {
        return this.variable.toString() + ';';
    }
}
