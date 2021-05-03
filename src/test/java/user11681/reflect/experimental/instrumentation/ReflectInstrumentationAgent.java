package user11681.reflect.experimental.instrumentation;

import java.lang.instrument.Instrumentation;

public class ReflectInstrumentationAgent {
    public static Instrumentation instrumentation;

    public static void premain(Instrumentation instrumentation) {
        init(instrumentation);
    }

    public static void agentmain(Instrumentation instrumentation) {
        init(instrumentation);
    }

    private static void init(Instrumentation instrumentation) {
        ReflectInstrumentationAgent.instrumentation = instrumentation;

        instrumentation.addTransformer(new ReflectTransformer());
    }
}
