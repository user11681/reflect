package user11681.reflect.generator.base.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import user11681.reflect.experimental.Copyable;
import user11681.reflect.generator.base.type.Type;

public class Invocation implements ExpressionStatement, Copyable<Invocation> {
    protected boolean instance;
    protected Expression object;
    protected Type type;
    protected String name;
    protected ArrayList<Expression> arguments = new ArrayList<>();

    public Invocation() {}

    public Invocation(String name, Expression... arguments) {
        this.name(name).argument(arguments);
    }

    public Invocation(Class<?> owner, Expression... arguments) {
        this.owner(owner).argument(arguments);
    }

    public Invocation(Class<?> owner, String name, Expression... arguments) {
        this.owner(owner).name(name).argument(arguments);
    }

    public Invocation(Type owner, String name, Expression... arguments) {
        this.owner(owner).name(name).argument(arguments);
    }

    public Invocation instance(boolean instance) {
        this.instance = instance;

        return this;
    }

    public Invocation owner(Expression owner) {
        this.object = owner;
        this.instance = true;

        return this;
    }

    public Invocation owner(Type owner) {
        this.type = owner;

        return this;
    }

    public Invocation owner(Class<?> owner) {
        return this.owner(new ConcreteType(owner));
    }

    public Invocation name(String name) {
        this.name = name;

        return this;
    }

    public Invocation argument(Expression... arguments) {
        this.arguments.addAll(Arrays.asList(arguments));

        return this;
    }

    @Override
    public Statement statement() {
        return new InvocationStatement(this);
    }

    @Override
    public Invocation copy() {
        Invocation copy = Copyable.super.copy();
        copy.arguments = (ArrayList<Expression>) this.arguments.clone();

        return copy;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (this.instance) {
            string.append(this.object == null ? "this" : this.object.toString()).append('.');
        } else if (this.type != null) {
            string.append(this.type.simpleName()).append('.');
        }

        string.append(this.name).append("(").append(this.arguments.stream().map(Expression::toString).collect(Collectors.joining(", "))).append(')');

        return string.toString();
    }
}
