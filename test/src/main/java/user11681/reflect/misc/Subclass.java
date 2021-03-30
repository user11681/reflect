package user11681.reflect.misc;

import java.util.function.Supplier;

public class Subclass extends Superclass {
    public Subclass() {

        super(((Supplier<String[]>) () -> {
            String[] elements = new String[10];

            for (int i = 0; i < elements.length; i++) {
                elements[i] = Integer.toString(i);
            }

            return elements;
        }).get());
    }
}
