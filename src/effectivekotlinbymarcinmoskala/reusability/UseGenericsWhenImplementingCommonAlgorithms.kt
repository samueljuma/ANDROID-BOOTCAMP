package effectivekotlinbymarcinmoskala.reusability

/**
 *Type parameters are an important part of Kotlin typing system. We
 * use them to have type-safe generic algorithms or generic objects.
 * Type parameters can be constrained to be a subtype of a concrete
 * type. When they are, we can safely use methods offered by this
 * type.
 */

inline fun <reified T> testFun(value: T): T{
    return value
}

fun <T> doThis(value: T, transform: (T) -> T): T {
   return transform(value)
}

fun main(){
    print(testFun(0.1))
}