package user11681.reflect.generator.base.method.expression;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.util.Extensible;
import user11681.reflect.generator.base.util.Union;

public class GetField implements Expression, Extensible<GetField> {
    protected final Union<TypeReferencer> owner = this.union(ConcreteType.class, "owner", Expression.class);

    protected boolean instance;

    public GetField() {
        this.simple(String.class, "name");
    }

    public GetField(Field field) {
        this();

        this.of(field.getDeclaringClass()).name(field.getName());
    }

    public GetField of(Class<?> type) {
        return this.of(new ConcreteType(type));
    }

    public GetField of(ConcreteType type) {
        return this.set(owner, type);
    }

    public GetField of(Expression object) {
        this.instance = true;

        return this.set(owner, object);
    }

    public GetField name(String name) {
        return this.set("name", name);
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.owner.get().referencedTypes();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (this.instance) {
            string.append(Objects.requireNonNullElse(this.owner.get(), "this")).append('.');
        } else if (this.owner.present()) {
            string.append(this.owner.get()).append('.');
        }

        string.append(this.<Object>get("name"));

        return string.toString();
    }
}
