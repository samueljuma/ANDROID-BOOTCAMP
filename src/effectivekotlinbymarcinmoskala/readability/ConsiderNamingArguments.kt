package effectivekotlinbymarcinmoskala.readability

import kotlinx.coroutines.delay

/**
 * Named arguments are not only useful when we need to skip
 * some default values. They are important information for developers
 * reading our code, and they can improve the safety of our code. We
 * should consider them especially when we have more parameters
 * with the same type (or with functional types) and for optional
 * arguments. When we have multiple parameters with functional
 * types, they should almost always be named. An exception is the
 * last function argument when it has a special meaning, like in DSL.
 */


suspend fun main(){
    val text = (1..10).joinToString(separator = " | ")
    print(text)
    delay(timeMillis = 1000L)


}



