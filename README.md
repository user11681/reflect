reflect is a Java reflection library that tries to overcome the restrictions on reflection
and make it concise while achieving higher performance by utilizing `Unsafe`.

Although reflect does not trigger the illegal access logger and provides facilities
in order to avoid that, said logger can be disabled nonetheless.
The security manager can be disabled too.

It reduces the usual verbosity of reflection by providing concise methods for most reflective operations (and more).
**None of these methods declares thrown exceptions.**

Currently, it should be compatible with Java versions 8 and above.
However, since I made it primarily for use in Minecraft,
I intend to drop support for Java 8 should Mojang update the JRE included
in the official launcher due to maintenance burden and bloat.

I try to keep this library mostly stable, although occasionally (with prior notice) I may break things.

reflect is hosted on Bintray. It depends on [my fork](https://github.com/user11681/unsafe) of [unsafe](https://github.com/gudenau/java-unsafe).
```groovy
repositories {
    maven {url = "https://dl.bintray.com/user11681/maven"}
}

dependencies {
    // Use "latest.release" for the latest version or see
    // https://dl.bintray.com/user11681/maven/net/gudenau/lib/unsafe and
    // https://dl.bintray.com/user11681/maven/user11681/reflect
    api("net.gudenau.lib:unsafe:latest.release")
    api("user11681:reflect:latest.release")
}
```

## a brief summary of classes
- `Accessor`: a collection of methods for reading and mutating fields
- `Classes`: a set of methods for working with classes (`defineClass`, change class of object)
- `ConstantPool`: a proxy for the JDK's internal `ConstantPool` that reads constant pools
- `EnumConstructor`: a class that constructs enum constants and adds them to the `values` array and a few other places;
  it can be used through static methods or directly as an object (more performant)
- `Fields`: a set of utilities for enumerating class fields directly (without slow security checks)
  and without filters
- `Invoker`: a static proxy for `IMPL_LOOKUP`, which should be able to access everything;
  its methods do not declare thrown exceptions
- `JavaLangAccess`: a partial proxy for `JavaLangAccess`
- `Methods`: a collection of utilities for listing class methods and dealing with them
- `Pointer`: a field reference that is similar to `Field` and does not force exceptions to be handled;
  intended for use with frequently accessed fields
- `Reflect`: a container for useful state
  and a set of methods that disable security manager and illegal access logger
- `Types`: a collection of methods for dealing with `Class`es
  (mainly conversion between primitive and wrapper types)

In addition to tests, the `test` subproject contains various experiments that I perform
to test the limits of reflection and decide if something should be added to reflect.
Some of them are irrelevant but I keep them anyway.
