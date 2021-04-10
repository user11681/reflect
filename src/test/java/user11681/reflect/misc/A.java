package user11681.reflect.misc;

import java.util.Random;
import net.gudenau.lib.unsafe.Unsafe;

public class A implements Cloneable {
    public static final String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static final Random random = new Random();

    public static String a0;
    public static String a1;
    public String a2;
    public double yes;
    public long no;
    public byte l;

    public A() {
        this.a2 = "a1";
        this.yes = 1;
        this.no = 0;
        this.l = 8;
    }

    public A(A that) {
        this.a2 = that.a2;
        this.yes = that.yes;
        this.no = that.no;
        this.l = that.l;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    private static String privateMethod() {
        return strings[random.nextInt(10)];
    }

    private static String privateMethod2(int number) {
        return strings[random.nextInt(10)];
    }

    public String message() {
        return "a";
    }

    public void print() {
        System.out.println(this.message());
    }
}
