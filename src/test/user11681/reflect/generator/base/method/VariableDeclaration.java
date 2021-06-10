package user11681.reflect.generator.base.method;

import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.statement.Statement;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.type.Type;

public class VariableDeclaration implements Statement {
    protected Type type;
    protected String name;
    protected Expression initializer;

    public VariableDeclaration type(Class<?> type) {
        return this.type(new ConcreteType(type));
    }

    public VariableDeclaration type(Type type) {
        this.type = type;

        return this;
    }

    public VariableDeclaration name(String name) {
        this.name = name;

        return this;
    }

    public VariableDeclaration initialize(Expression initializer) {
        this.initializer = initializer;

        return this;
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.concat(Stream.of(this.type), Stream.ofNullable(this.initializer)).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder().append(this.type).append(' ').append(this.name);

        if (this.initializer != null) {
            string.append(" = ").append(this.initializer);
        }

        return string.append(';').toString();
    }

    protected Variable variable() {
        return new Variable(this.type, this.name);
    }
}
