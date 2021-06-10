package user11681.reflect.generator.base.util;

import java.util.Arrays;
import java.util.List;

public class Union<T> extends Property<T> {
    protected final List<Class<?>> types;
    protected final Class<?> defaultType;

    protected Class<?> type;

    @SafeVarargs
    protected Union(String name, Class<? extends T> defaultType, Class<? extends T>... otherTypes) {
        super(name);

        this.types = Arrays.asList(Arrays.copyOf(otherTypes, otherTypes.length + 1));
        this.types.set(otherTypes.length, defaultType);
        this.defaultType = defaultType;
    }

    @Override
    public void set(Object value) {
        super.set(value);

        if (value == null) {
            if (this.type == null) {
                this.type = this.defaultType;
            }
        } else {
            Class<?> newType = value.getClass();

            if (this.type == null) {
                this.type = newType;
            } else if (newType != this.type) {
                throw new ClassCastException("wrong type %s for specialized union of %s".formatted(newType.getName(), this.type.getName()));
            }
        }
    }

    public Class<?> type() {
        return this.type;
    }

    public boolean is(Class<?> type) {
        return this.type == type;
    }
}
