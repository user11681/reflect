package user11681.reflect.other;

import java.util.Random;

public class TestObject {
    public static final Random random = new Random();

    public final int integer = getRandom().nextInt();
    public final long loong = getRandom().nextLong();
    public final boolean bool = getRandom().nextBoolean();
    public final short shrt = (short) getRandom().nextInt();
    public final char character = (char) getRandom().nextInt();
    public final float floatt = getRandom().nextFloat();
    public final double dubble = getRandom().nextDouble();
    public final Object obyect = new IntWrapper(getRandom().nextInt());

    public volatile int integerVolatile = getRandom().nextInt();
    public volatile long loongVolatile = getRandom().nextLong();
    public volatile boolean boolVolatile = getRandom().nextBoolean();
    public volatile short shrtVolatile = (short) getRandom().nextInt();
    public volatile char characterVolatile = (char) getRandom().nextInt();
    public volatile float floattVolatile = getRandom().nextFloat();
    public volatile double dubbleVolatile = getRandom().nextDouble();
    public volatile Object obyectVolatile = new IntWrapper(getRandom().nextInt());

    public static Random getRandom() {
        return random;
    }

    public int getInteger() {
        return integer;
    }

    public long getLoong() {
        return loong;
    }

    public boolean isBool() {
        return bool;
    }

    public short getShrt() {
        return shrt;
    }

    public char getCharacter() {
        return character;
    }

    public float getFloatt() {
        return floatt;
    }

    public double getDubble() {
        return dubble;
    }

    public Object getObyect() {
        return obyect;
    }

    public int getIntegerVolatile() {
        return integerVolatile;
    }

    public void setIntegerVolatile(int integerVolatile) {
        this.integerVolatile = integerVolatile;
    }

    public long getLoongVolatile() {
        return loongVolatile;
    }

    public void setLoongVolatile(long loongVolatile) {
        this.loongVolatile = loongVolatile;
    }

    public boolean isBoolVolatile() {
        return boolVolatile;
    }

    public void setBoolVolatile(boolean boolVolatile) {
        this.boolVolatile = boolVolatile;
    }

    public short getShrtVolatile() {
        return shrtVolatile;
    }

    public void setShrtVolatile(short shrtVolatile) {
        this.shrtVolatile = shrtVolatile;
    }

    public char getCharacterVolatile() {
        return characterVolatile;
    }

    public void setCharacterVolatile(char characterVolatile) {
        this.characterVolatile = characterVolatile;
    }

    public float getFloattVolatile() {
        return floattVolatile;
    }

    public void setFloattVolatile(float floattVolatile) {
        this.floattVolatile = floattVolatile;
    }

    public double getDubbleVolatile() {
        return dubbleVolatile;
    }

    public void setDubbleVolatile(double dubbleVolatile) {
        this.dubbleVolatile = dubbleVolatile;
    }

    public Object getObyectVolatile() {
        return obyectVolatile;
    }

    public void setObyectVolatile(Object obyectVolatile) {
        this.obyectVolatile = obyectVolatile;
    }
}
