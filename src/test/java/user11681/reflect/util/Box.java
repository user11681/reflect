package user11681.reflect.util;

public class Box {
    public Object o;

    public <T> T o() {
        return (T) this.o;
    }
}
