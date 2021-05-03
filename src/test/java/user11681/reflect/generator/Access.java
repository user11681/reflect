package user11681.reflect.generator;

import java.util.Locale;
import java.util.function.Consumer;

public enum Access {
    GET,
    PUT;

    public boolean get() {
        return this == GET;
    }

    public boolean put() {
        return this == PUT;
    }

    public void get(Runnable action) {
        if (this.get()) {
            action.run();
        }
    }

    public void put(Runnable action) {
        if (this.put()) {
            action.run();
        }
    }

    public <T> Next put(T arg, Consumer<T> action) {
        Next next = new Next(this.put());

        if (next.result) {
            action.accept(arg);
        }

        return next;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public static record Next(boolean result) {
        public void otherwise(Runnable action) {
            if (!this.result) {
                action.run();
            }
        }
    }
}
