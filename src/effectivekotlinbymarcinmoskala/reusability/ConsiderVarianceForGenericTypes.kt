package effectivekotlinbymarcinmoskala.reusability


class Cup<T> (
    val name: T
)

fun main(){
    val cup = Cup<Any>(name = 1)
    println(cup.name)
}