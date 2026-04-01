package effectivekotlinbymarcinmoskala.safety

open class Animal()
class Zebra: Animal()

fun main(){
    var animal = Zebra() // Notice inferred type is Zebra
//    animal = Animal()

    var animal2: Animal = Zebra() // type explicitly specified.
    animal2 = Animal()
}