package user11681.reflect;

import java.util.Random;

public class A {
    public static final String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static final Random random = new Random();

    public static String a0;
    public static String a1;
    public String a2;

    private static String privateMethod() {
        return strings[random.nextInt(10)];
    }

    private static String privateMethod2(final int number) {
        return strings[random.nextInt(10)];
    }
}
