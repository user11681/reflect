package user11681.reflect.experimental;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StackFrames {
    public static final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    public static StackTraceElement[] trace() {
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement traceFrame(int depth) {
        return trace()[3 + depth];
    }

    public static StackTraceElement traceFrame() {
        return trace()[3];
    }

    public static Class<?> caller() {
        return walker.getCallerClass();
    }

    public static Class<?> caller(int depth) {
        return frame(depth + 1).getDeclaringClass();
    }

    public static StackWalker.StackFrame frame() {
        return frame(1);
    }

    public static StackWalker.StackFrame frame(int depth) {
        return walker.walk((Stream<StackWalker.StackFrame> frames) -> {
            Iterator<StackWalker.StackFrame> iterator = frames.iterator();

            for (int remaining = depth; remaining >= 0 && iterator.hasNext(); remaining--, iterator.next()) {}

            return iterator.next();
        });
    }

    public static List<StackWalker.StackFrame> frames() {
        return walker.walk((Stream<StackWalker.StackFrame> frames) -> {
            Iterator<StackWalker.StackFrame> iterator = frames.iterator();
            iterator.next();

            List<StackWalker.StackFrame> list = new ArrayList<>();
            iterator.forEachRemaining(list::add);

            return list;
        });
    }
}
