package effectivekotlinbymarcinmoskala.safety

import java.awt.Color

data class User(
    val username: String,
    val email: String
)

fun main(){
    val users = listOf(
        User("jumas", "jums@gmail.com"),
        User("sammy", "sammy@gmail.com"),
        User("sam", "sam@gmail.com"),
    )

    // BAD
    var user: User
    for(i in users.indices){
        user = users[i]
        println("User at $i is ${user.username}")
    }


    // BETTER
    for(i in users.indices){
        val user = users[i]
        println("User at $i is ${user.username}")
    }

    for((i, user) in users.withIndex()){
        println("User at $i is ${user.username}")
    }

    val (num1, num2) = 9 to 10

    println(num1 + num2)

    users.forEachIndexed { index, user ->
        println("User at $index is $${user.username}")
    }
    updateWeather(20.0)
}

fun updateWeather(degrees: Double){
    val(description, color) = when{
        degrees < 5 -> "cold" to Color.BLUE
        degrees < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }
    println(description)
    println("Color $color")
}