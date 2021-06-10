package user11681.reflect.generator.base;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.type.Type;

public class FieldBuilder extends MemberBuilder<FieldBuilder> {
    protected Type type;
    protected Expression initializer;

    public FieldBuilder type(Type type) {
        this.type = type;

        return this;
    }

    public FieldBuilder type(Class<?> type) {
        return this.type(new ConcreteType(type));
    }

    public FieldBuilder name(String name) {
        this.name = name;

        return this;
    }

    public FieldBuilder initialize(Expression initializer) {
        this.initializer = initializer;

        return this;
    }

    public FieldBuilder inherit(Field field) {
        this.access(field.getModifiers());
        this.type(field.getType());
        this.name(field.getName());

        return this;
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.of(this.type, this.initializer).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(Modifier.toString(this.access))
            .append(' ')
            .append(this.type)
            .append(' ')
            .append(this.name);

        if (this.initializer != null) {
            string.append(" = ").append(this.initializer);
        }

        return string.append(';').toString();
    }
}
