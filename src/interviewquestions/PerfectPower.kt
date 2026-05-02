package interviewquestions

import java.lang.StrictMath.pow
import kotlin.math.log2

/**
 * A perfect power is a classification of positive integers:
 * In mathematics, a perfect power is a positive integer that can
 * be expressed as an integer power of another positive integer. More
 * formally, n is a perfect power if there exist natural numbers m > 1,
 * and k > 1 such that mk = n.
 * Your task is to check whether a given integer is a perfect power. If it
 * is a perfect power, return a pair m and k with mk = n as a proof. Otherwise,
 * return Nothing, Nil, nil, null, NULL, None or your language's equivalent.
 * Note: For a perfect power, there might be several pairs.
 * For example 81 = 3^4 = 9^2, so (3,4) and (9,2) are valid solutions.
 * However, the tests take care of this, so if a number is a perfect power,
 * return any pair that proves it.
 */

fun main(){
    println(pow(2.0,3.0))
    println(isPerfectPower(10))
}

fun isPerfectPower(n: Int): List<Int>? {
    if (n < 4) return null // smallest perfect power is 4 = 2^2

    val maxK = log2(n.toDouble()).toInt()

    for (k in 2..maxK) {
        val m = pow(n.toDouble(), 1.0 / k).toInt()

        // Check both m and m+1 to avoid floating point precision issues
        if (pow(m.toDouble(), k.toDouble()).toInt() == n) {
            return listOf(m,k)
        }
        if (pow((m + 1).toDouble(), k.toDouble()).toInt() == n) {
            return listOf((m + 1), k)
        }
    }

    return null
}