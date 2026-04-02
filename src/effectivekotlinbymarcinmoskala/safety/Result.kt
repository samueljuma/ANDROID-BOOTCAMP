package effectivekotlinbymarcinmoskala.safety

/**
 *Sometimes, a function cannot produce its desired result. A few
 * common examples are:
 * • We try to get data from some server, but there is a problem
 * with our internet connection
 * • We try to get the first element that matches some criteria, but
 * there is no such element in our list
 * • We try to parse an object from the text, but this text is
 * malformatted
 * There are two main mechanisms to handle such situations:
 * • Return a null or a sealed class indicating failure (that is often
 * named Failure)
 * • Throw an exception
 */
sealed class Result<out D, out E> {
    data class Success<out D>(val data: D): Result<D, Nothing>()
    data class Error<out E: AppError>(val error: E): Result<Nothing, E>()
}

interface AppError

enum class NetworkError(val errorMessage: String? = null): AppError{
    NO_INTERNET("Oops! You don't have internet"),
    BAD_REQUEST("Bad Request this One")
}

fun doSomething(value: Int): Result<String, NetworkError> {
    return when {
        value < 0 -> Result.Error(NetworkError.NO_INTERNET)
        value in 1..10 -> Result.Error(NetworkError.BAD_REQUEST)
        else -> Result.Success("Good Value")
    }
}

fun main(){
    when(val result = doSomething(-1)){
        is Result.Error -> println(result.error.errorMessage)
        is Result.Success -> println(result.data)
    }
}

