// FIR_IDENTICAL
// !LANGUAGE: +ContextReceivers
// DUMP_LOCAL_DECLARATION_SIGNATURES
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6

// MUTE_SIGNATURE_COMPARISON_K2: ANY
// ^ KT-57428, KT-57435

interface Lazy<T>

context(Lazy<Int>, Lazy<CharSequence>)
fun test1() {}

context(Lazy<T>)
fun <T> Lazy<Int>.test2() {}

context(Lazy<Lazy<T>>)
fun <T> Lazy<Int>.test3() {}

fun <T> f(lazy1: Lazy<Int>, lazy2: Lazy<CharSequence>, lazyT: Lazy<T>, lazyLazyT: Lazy<Lazy<T>>) {
    with(lazy1) {
        with(lazy2) {
            test1()
            test2()
        }
    }
    with(lazy2) {
        with(lazy1) {
            test1()
            test2()
        }
    }
    with(lazyT) {
        with(lazy1) {
            test2()
        }
    }
    with(lazyLazyT) {
        with(lazy1) {
            test2()
            test3()
        }
    }
    with(lazy1) {
        with(lazyLazyT) {
            test2()
            test3()
        }
    }
}
