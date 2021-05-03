package user11681.reflect.generator.base.method;

import user11681.reflect.generator.base.method.expression.Expression;

public class LoopVariable {
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
    public String toString() {
        StringBuilder builder = new StringBuilder(this.name);

        if (this.initializer == null) {
            builder.append(';');
        } else builder.append(" = ").append(this.initializer);

        return builder.toString();
    }
}
