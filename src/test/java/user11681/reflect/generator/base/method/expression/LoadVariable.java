package user11681.reflect.generator.base.method.expression;

import user11681.reflect.generator.base.method.Variable;

public record LoadVariable(Variable variable) implements Expression {
    @Override
    public String toString() {
        return this.variable.name();
    }
}
