package user11681.reflect.generator.base.method.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.method.LoopVariable;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.type.Type;
import user11681.reflect.util.Util;

public class For implements Statement {
    protected Type variableType;
    protected Expression condition;
    protected Statement action;
    protected List<LoopVariable> variables = new ArrayList<>();
    protected List<Statement> post = new ArrayList<>();

    public For variableType(Type type) {
        this.variableType = type;

        return this;
    }

    public For variable(LoopVariable variable) {
        this.variables.add(variable);

        return this;
    }

    public For condition(Expression condition) {
        this.condition = condition;

        return this;
    }

    public For post(Statement statement) {
        this.post.add(statement);

        return this;
    }

    public For action(Statement action) {
        this.action = action;

        return this;
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Util.join(Stream.of(this.variableType, this.condition, this.action), this.variables.stream(), this.post.stream()).filter(Objects::nonNull).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("for (");

        if (this.variableType == null ^ variables.isEmpty()) {
            throw new IllegalStateException();
        }

        if (this.variableType != null) {
            string.append(this.variableType);
            string.append(this.variables.stream().map(LoopVariable::toString).collect(Collectors.joining(", ", " ", "")));
        }

        string.append(';');

        if (this.condition != null) {
            string.append(this.condition);
        }

        string.append(';');

        if (!this.post.isEmpty()) {
            string.append(this.post.stream().map(Statement::toString).collect(Collectors.joining(", ")));
        }

        string.append(')');

        if (this.action == null) {
            string.append(';');
        } else string.append(' ').append(this.action);

        return string.toString();
    }
}
