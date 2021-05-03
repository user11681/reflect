package user11681.reflect.generator.base;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.type.Type;

public class FieldGenerator extends MemberGenerator<FieldGenerator> {
    protected Type type;
    protected Expression initializer;

    public FieldGenerator type(Type type) {
        this.type = type;

        return this;
    }

    public FieldGenerator type(Class<?> type) {
        return this.type(new ConcreteType(type));
    }

    public FieldGenerator name(String name) {
        this.name = name;

        return this;
    }

    public FieldGenerator initialize(Expression initializer) {
        this.initializer = initializer;

        return this;
    }

    public FieldGenerator inherit(Field field) {
        this.access(field.getModifiers());
        this.type(field.getType());
        this.name(field.getName());

        return this;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(Modifier.toString(this.access))
            .append(' ')
            .append(this.type.simpleName())
            .append(' ')
            .append(this.name);

        if (this.initializer != null) {
            string.append(" = ").append(this.initializer);
        }

        return string.append(';').toString();
    }
}
