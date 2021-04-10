package user11681.reflect.asm;

public interface BitField {
    int flags();

    default boolean has(int... flags) {
        return has(this.flags(), flags);
    }

    static boolean has(int field, int... flags) {
        for (int flag : flags) {
            if ((field & flag) == 0) {
                return false;
            }
        }

        return true;
    }
}
