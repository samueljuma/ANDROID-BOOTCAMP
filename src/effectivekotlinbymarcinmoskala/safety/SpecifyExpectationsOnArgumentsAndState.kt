package effectivekotlinbymarcinmoskala.safety

import kotlin.math.log

/**
 * When you have expectations, declare them as soon as possible. We
 * do that in Kotlin mainly using:
 * • require block - a universal way to specify expectations on
 * arguments.
 * • check block - a universal way to specify expectations on the
 * state.
 * • assert block - a universal way to check if something is true.
 * Such checks on the JVM will be evaluated only on the testing
 * mode.
 * • Elvis operator with return or throw.
 */

/**
 * The check function works similarly to require, but it throws
 * an IllegalStateException when the stated expectation is not
 * met.
 */

fun addTwo(num1: Int, num2: Int?){

    num2 ?: throw Exception("You can not have a null")

    require(num1 >= 0 && num2 >= 0){
        throw IllegalArgumentException("You need a bit of seriousness in your life")
    }
    val result = num2 + num1

    check(result == 0){
        "You can not have a zero balance, change your inputs"
    }

    assert(num2 !=2){
        "Your second number should never be a 2"
    }
}

class CustomException: Exception()

data class UserInfo(
    val token: String
)

fun UserInfo?.getUserInfo(): UserInfo{
    checkNotNull(this?.token)

    return UserInfo(token)
}

fun doThis(myString: String?){
    myString ?: run {
        // Perfect for logs
//        log("Email not sent, no email address")
        print("There was an empty string!")
    }
}

fun main(){
//    addTwo(0, -1)
//    val user = UserInfo("TYT#766373263HGD")
//    val user = null
//    user.getUserInfo()
    doThis(null)

}
