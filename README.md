reflect is a Java reflection library that uses Unsafe in order to circumvent security checks and achieve _speed_.<br>
It should be compatible with Java versions 8 and above. When run with Java 9 or newer, it also disables the illegal access logger.<br>
It reduces the usual verbosity of reflection by providing concise methods for most reflective operations.

reflect requires [unsafe](https://github.com/user11681/unsafe).

This library is hosted on Bintray.
```groovy
repositories {
    maven {url = "https://dl.bintray.com/user11681/maven"}
}

dependencies {
    // Use "+" for the latest version or see
    // https://dl.bintray.com/user11681/maven/net/gudenau/lib/unsafe and
    // https://dl.bintray.com/user11681/maven/user11681/reflect
    api("net.gudenau.lib:unsafe:+")
    api("user11681:reflect:+")
}
```
