package interviewquestions

fun isPalindrome1(x: Int): Boolean {
    val initialString = x.toString()
    val reverseString = initialString.reversed()

    return initialString == reverseString
}

fun main(){
    val value = 120011
    print(isPalindrome(value))

}

fun isPalindrome(value: Int): Boolean{
    val valueString = value.toString()

        if (value < 0)  return false

        valueString.forEachIndexed { index, value ->
            if(index == valueString.length - (index + 1)) return true
            if(value != valueString[valueString.length - (index + 1)]) {
                return false
            }
        }

    return true
}

/**
 * Very Optimal - Takes less space and less time
 */
fun isPalindrome2(x: Int): Boolean {
    // Edge cases
    if (x < 0 || (x % 10 == 0 && x != 0)) return false

    var num = x
    var reversedHalf = 0

    while (num > reversedHalf) {
        reversedHalf = reversedHalf * 10 + num % 10
        num /= 10
    }

    return num == reversedHalf || num == reversedHalf / 10
}


fun isPalindromeString(x: String): Boolean {
    // Edge cases
    if(x.isBlank() || x.length == 1) return true



    return false
}