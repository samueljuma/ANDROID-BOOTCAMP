package effectivekotlinbymarcinmoskala.safety

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class InsufficientBalance: Exception()

class BankAccount{
    var balance = 0.0
        private set

    fun deposit(amount:Double){
        balance += amount
    }

    @Throws(InsufficientBalance::class)
    fun withdraw(amount: Double){
        if(balance < amount) throw InsufficientBalance()
        balance -= amount
    }
}

fun threadExample(){
    val lock = Any()
    var num = 0
    for(i in 1..1000){
        thread {
            Thread.sleep(10)
            synchronized(lock){
                num +=1
            }
        }
    }
    Thread.sleep(5000)
    println(num)
}

suspend fun coroutineSample(){
    val lock = Any()
    var num = 0
    coroutineScope {
        for (i in 1..1000) {
            launch {
                delay(10)
                synchronized(lock){
                    num += 1
                }

            }
        }
    }
    println(num)
}

suspend fun main(){
    threadExample()
    coroutineSample()
}

class Sample{
    val firstName: String? = "John"
    val lastName: String? = "Doe"
    val fullName: String?
        get() = "$firstName  $lastName"
    val fullName2: String? = firstName?.let { "$it $lastName" }
    fun printName(){
        if(fullName != null){
//            print(fullName.length) // Error
        }
    }

    fun printName2(){
        if(fullName2 != null){
//            print(fullName.length) // Error
        }
    }
}



data class Person(
    val firstName: String,
    val lastName: String
){
    val fullName
        get() = "$firstName $lastName"
    val fullName2 = "$firstName $lastName"
}

interface Element{
    val text: String
}

class RealElement: Element{
    override var text: String = "Real Element"
}