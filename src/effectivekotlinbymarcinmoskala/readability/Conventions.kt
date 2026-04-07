package effectivekotlinbymarcinmoskala.readability

/**
 * Bad Practice as far as conventions are concerned
 * [invoke] should not be used this way. A String cannot be invoked.
 * • The usage of the ‘lambda as the last argument’ convention
 * here is confusing. It is fine to use it after functions, but we
 * should be very careful when we use it for the invoke operator.
 * • [and] is clearly a bad name for this infix method. [append] or
 * [plus] would be much better.
 * • We already have language features for String concatenation
 * and we should use them instead of reinventing the wheel.
 */
infix fun String.and(s: String) = this + s

operator fun String.invoke(f: () -> String): String = this + f()


fun main(){
    println("Sam" and " Juma")
    val abc = "A" {"B"} and "C"
    println(abc)
}

/**
 * Use operator overloading conscientiously. The function name should
 * always be coherent with its behavior. Avoid cases where operator
 * meaning is unclear. Clarify it by using a regular function with a
 * descriptive name instead. If you wish to have a more operator-like
 * syntax, then use the infix modifier or a top-level function.
 */