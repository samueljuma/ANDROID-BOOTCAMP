package effectivekotlinbymarcinmoskala.reusability

/**
 * You don't need to re-implement the same algorithms again and again
 * A good example is coercion in a range
 */




fun main(){
    print("Enter a Number:")
    val numberFromUser = readlnOrNull()?.toInt() ?: return

    // Re-writing the coerceIn algo
    val percent = when {
        numberFromUser > 100 -> 100
        numberFromUser < 0 -> 0
        else -> numberFromUser
    }

    val percent1 = numberFromUser.coerceIn(0, 100)

    println("$percent %")
    println("$percent1 %")

}

fun Iterable<Int>.product() = fold(1) {acc, i -> acc * i}

