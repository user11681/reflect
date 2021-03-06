package user11681.reflect.generator.base.method.statement;

import java.util.Objects;
import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.operator.Equality;
import user11681.reflect.generator.base.type.ConcreteType;

public class If implements Statement {
    protected Expression condition;
    protected Statement ifTrue;
    protected Statement ifFalse;

    public If condition(Expression condition) {
        this.condition = condition;

        return this;
    }

    public If same(Expression left, Expression right) {
        return this.condition(new Equality(left, right));
    }

    public If nul(Expression expression) {
        return this.condition(Equality.nul(expression));
    }

    public If then(Statement statement) {
        this.ifTrue = statement;

        return this;
    }

    public If otherwise(Statement statement) {
        this.ifFalse = statement;

        return this;
    }

    public If otherwiseIf(Expression condition) {
        return new If().condition(condition);
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.of(this.condition, this.ifTrue, this.ifFalse).filter(Objects::nonNull).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("if (%s) %s".formatted(this.condition, this.ifTrue));

        if (this.ifFalse != null) {
            string.append(" else ").append(this.ifFalse);
        }

        return string.toString();
    }
}
