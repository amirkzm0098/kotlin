// !LANGUAGE: -ForbidUsingExtensionPropertyTypeParameterInDelegate
//For KT-6020
// KT-58555
// IGNORE_BACKEND_K2: NATIVE

import kotlin.reflect.KProperty1
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty

class Value<T>(var value: T = null as T, var text: String? = null)

val <T> Value<T>.additionalText by DVal(Value<T>::text) //works

val <T> Value<T>.additionalValue by DVal(Value<T>::value) //not work

class DVal<T, R, P: KProperty1<T, R>>(val kmember: P) {
    operator fun getValue(t: T, p: KProperty<*>): R {
        return kmember.get(t)
    }
}

fun box(): String {
    val p = Value("O", "K")
    return p.additionalValue + p.additionalText
}
