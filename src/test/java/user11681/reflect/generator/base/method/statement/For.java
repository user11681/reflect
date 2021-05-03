package user11681.reflect.generator.base.method.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.LoopVariable;
import user11681.reflect.generator.base.type.Type;

public class For implements Statement {
    protected Type variableType;
    protected Expression condition;
    protected List<LoopVariable> variables = new ArrayList<>();
    protected List<Statement> post = new ArrayList<>();
    protected Statement action;

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
    public String toString() {
        StringBuilder string = new StringBuilder("for (");

        if (this.variableType == null ^ variables.isEmpty()) {
            throw new IllegalStateException();
        }

        if (this.variableType != null) {
            string.append(this.variableType.simpleName());
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
