// TARGET_BACKEND: JVM

// MUTE_SIGNATURE_COMPARISON_K2: ANY
// ^ KT-57429

// FILE: Foo.java

public class Foo {
    public abstract static class Bar extends Foo {

    }

    public static class Buz extends Bar {
        public String str = "OK";
    }
}

// FILE: Box.kt

class Box<out T : Foo>(val foo: T) {
    val str: String
        get() {
            var foo: Foo = foo
            if (foo is Foo.Buz) {
                return foo.str
            }
            return "";
        }
}
