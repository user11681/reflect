package user11681.reflect.generator.base.method.statement;

import java.util.stream.Stream;
import user11681.reflect.generator.base.method.expression.Invocation;
import user11681.reflect.generator.base.type.ConcreteType;

public record InvocationStatement(Invocation invocation) implements Statement {
    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.invocation.referencedTypes();
    }

    @Override
    public String toString() {
        return this.invocation.toString() + ';';
    }
}
