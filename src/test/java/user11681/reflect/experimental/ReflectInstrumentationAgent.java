package user11681.reflect.experimental;

import java.lang.instrument.Instrumentation;

public class ReflectInstrumentationAgent {
    public static Instrumentation instrumentation;

    public static void premain(final Instrumentation instrumentation) {
        init(instrumentation);
    }

    public static void agentmain(final Instrumentation instrumentation) {
        init(instrumentation);
    }

    private static void init(final Instrumentation instrumentation) {
        ReflectInstrumentationAgent.instrumentation = instrumentation;

        instrumentation.addTransformer(new ReflectTransformer());
    }
}
