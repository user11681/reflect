package user11681.reflect.generator.base.util;

public abstract class Property<T> {
    protected final String name;

    protected Object value;
    protected boolean present;

    protected Property(String name) {
        this.name = name;
    }

    public T get() {
        return (T) this.value;
    }

    public void set(Object value) {
        this.value = value;
        this.present = true;
    }

    public boolean present() {
        return this.present;
    }
}
