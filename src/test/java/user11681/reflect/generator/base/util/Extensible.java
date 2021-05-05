package user11681.reflect.generator.base.util;

import java.util.HashMap;
import java.util.Map;

public interface Extensible<T extends Extensible<T>> {
    Map<Extensible<?>, Map<String, Property<?>>> properties = new HashMap<>();

    default <P> P get(String property) {
        return this.get(this.property(property));
    }

    default <P> P get(Property<?> property) {
        return (P) property.get();
    }

    default T set(Property<?> property, Object value) {
        property.set(value);

        return (T) this;
    }

    default T set(String property, Object value) {
        return this.set(this.property(property), value);
    }

    default boolean has(String property) {
        return this.properties().containsKey(property);
    }

    default <P> Property<P> simple(Class<P> type, String name) {
        if (this.properties().containsKey(name)) {
            throw new IllegalStateException("property \"%s\" already declared".formatted(name));
        }

        Property<P> property = new SimpleProperty<>(type, name);
        this.properties().put(name, property);

        return property;
    }

    default Union union(String property, Class<?>... types) {
        return this.union(null, property, types);
    }

    default Union union(Class<?> defaultType, String name, Class<?>... otherTypes) {
        if (this.properties().containsKey(name)) {
            throw new IllegalStateException("property \"%s\" already declared".formatted(name));
        }

        Union union = new Union(name, defaultType, otherTypes);
        this.properties().put(name, union);

        return union;
    }

    default <P> Property<P> property(String name) {
        return (Property<P>) this.properties().get(name);
    }

    default Map<String, Property<?>> properties() {
        return properties.computeIfAbsent(this, copy -> new HashMap<>());
    }
}
