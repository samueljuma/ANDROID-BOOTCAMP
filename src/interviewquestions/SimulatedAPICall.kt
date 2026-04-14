package interviewquestions

import kotlinx.coroutines.delay
import java.lang.Exception

class ExceededMaxRetries(message: String, cause: Throwable): Exception(message, cause)

class RetrySolution{
    suspend fun <T> retryFunction(
        maxRetries: Int,
        baseDelay: Long,
        maxDelay: Long,
        apiCall: suspend () -> T
    ): T?{
        var retries = 0
        var currentDelay = baseDelay

        while(true){
            try {
                return apiCall()
            }catch(e: Exception){
                retries++
                if(retries >= maxRetries) throw ExceededMaxRetries("Exceeded max retries", e)

                delay(currentDelay)
                currentDelay = (currentDelay * 2).coerceAtMost(maxDelay)
            }
        }
    }
}

suspend fun <T> retryFunction(
    maxRetries: Int,
    baseDelay: Long,
    maxDelay: Long,
    apiCall: suspend () -> T
): T {
    var attempt = 0
    var currentDelay = baseDelay

    while (true) {
        try {
            return apiCall()
        } catch (e: Exception) {
            attempt++

            if (attempt > maxRetries) {
                throw ExceededMaxRetries(
                    "Max retries exceeded after $maxRetries attempts",
                    e
                )
            }

            delay(currentDelay)
            currentDelay = (currentDelay * 2).coerceAtMost(maxDelay)
        }
    }
}