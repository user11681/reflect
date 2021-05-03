package user11681.reflect.generator;

import java.util.Locale;

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

    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
