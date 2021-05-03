package user11681.reflect.generator.base.method;

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
    public String toString() {
        StringBuilder string = new StringBuilder().append(this.type.simpleName()).append(' ').append(this.name);

        if (this.initializer != null) {
            string.append(" = ").append(this.initializer);
        }

        return string.append(';').toString();
    }

    protected Variable variable() {
        return new Variable(this.type, this.name);
    }
}
