package user11681.reflect.generator.base.util;

public class SimpleProperty<T> extends Property<T> {
    protected Class<T> type;

    protected SimpleProperty(Class<T> type, String name) {
        super(name);

        this.type = type;
    }

    @Override
    public void set(Object value) {
        if (value != null && !this.type.isInstance(value)) {
            throw new ClassCastException("wrong type %s for %s %s".formatted(value.getClass(), this.type.getName(), this.name));
        }

        super.set(value);
    }
}
