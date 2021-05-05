package user11681.reflect.generator.base.method;

import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.type.ConcreteType;

public class LoopVariable implements TypeReferencer {
    protected String name;
    protected Expression initializer;

    public LoopVariable name(String name) {
        this.name = name;

        return this;
    }

    public LoopVariable initialize(Expression initializer) {
        this.initializer = initializer;

        return this;
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.initializer == null ? Stream.empty() : this.initializer.referencedTypes();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.name);

        if (this.initializer == null) {
            builder.append(';');
        } else builder.append(" = ").append(this.initializer);

        return builder.toString();
    }
}
