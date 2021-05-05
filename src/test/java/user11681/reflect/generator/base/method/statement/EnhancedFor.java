package user11681.reflect.generator.base.method.statement;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.method.Variable;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.type.Type;

public class EnhancedFor implements Statement {
    protected Variable variable;
    protected Expression iterable;
    protected Statement action;

    public EnhancedFor variable(Type type, String name) {
        this.variable = new Variable(type, name);

        return this;
    }

    public EnhancedFor variable(Class<?> type, String name) {
        return this.variable(new ConcreteType(type), name);
    }

    public EnhancedFor iterable(Expression iterable) {
        this.iterable = iterable;

        return this;
    }

    public EnhancedFor action(Statement action) {
        this.action = action;

        return this;
    }

    public EnhancedFor action(Function<Variable, Statement> action) {
        return this.action(action.apply(this.variable));
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.of(this.variable, this.iterable, this.action).filter(Objects::nonNull).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("for (%s : %s)".formatted(this.variable.declaration(), this.iterable));

        if (this.action == null) {
            string.append(';');
        } else string.append(' ').append(this.action);

        return string.toString();
    }
}
