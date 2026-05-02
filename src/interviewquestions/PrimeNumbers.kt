package interviewquestions

import kotlin.math.sqrt

fun Int.isPrime(): Boolean {
    val n = this
    if (n <= 1) return false
    if (n == 2) return true
    if (n % 2 == 0) return false

    val limit = sqrt(n.toDouble()).toInt()

    for (i in 3..limit step 2) {
        if (n % i == 0) return false
    }
    return true
}

fun main(){

}