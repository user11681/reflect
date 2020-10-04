package user11681.reflect;

import java.util.Random;

public class TestObject {
    public static final Random random = new Random();

    public final int integer = random.nextInt();
    public final long loong = random.nextLong();
    public final boolean bool = random.nextBoolean();
    public final short shrt = (short) random.nextInt();
    public final char character = (char) random.nextInt();
    public final float floatt = random.nextFloat();
    public final double dubble = random.nextDouble();
    public final Object obyect = new IntWrapper(random.nextInt());

    public volatile int integerVolatile = random.nextInt();
    public volatile long loongVolatile = random.nextLong();
    public volatile boolean boolVolatile = random.nextBoolean();
    public volatile short shrtVolatile = (short) random.nextInt();
    public volatile char characterVolatile = (char) random.nextInt();
    public volatile float floattVolatile = random.nextFloat();
    public volatile double dubbleVolatile = random.nextDouble();
    public volatile Object obyectVolatile = new IntWrapper(random.nextInt());
}
