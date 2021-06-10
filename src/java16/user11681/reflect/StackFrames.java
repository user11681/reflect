package user11681.reflect;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StackFrames {
    public static final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    public static Class<?> caller() {
        return caller(1);
    }

    public static Class<?> caller(int depth) {
        return frame(depth + 2).getDeclaringClass();
    }

    public static Class<?> caller(Predicate<? super StackWalker.StackFrame> predicate) {
        return walker.walk(frames -> frames.skip(2).filter(predicate).findFirst().orElseThrow().getDeclaringClass());
    }

    public static StackWalker.StackFrame frame() {
        return frame(1);
    }

    public static StackWalker.StackFrame frame(int depth) {
        return walker.walk(frames -> frames.skip(depth + 1).findFirst().orElseThrow());
    }

    public static StackWalker.StackFrame frame(Predicate<? super StackWalker.StackFrame> predicate) {
        return walker.walk(frames -> frames.skip(1).filter(predicate).findFirst().orElseThrow());
    }

    public static List<StackWalker.StackFrame> frames() {
        return walker.walk(frames -> frames.skip(1).toList());
    }

    public static StackTraceElement[] trace() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();

        return Arrays.copyOfRange(trace, 2, trace.length);
    }

    public static StackTraceElement traceFrame(int depth) {
        return trace()[1 + depth];
    }

    public static StackTraceElement traceFrame() {
        return traceFrame(1);
    }
}
