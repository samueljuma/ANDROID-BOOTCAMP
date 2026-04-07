package effectivekotlinbymarcinmoskala.readability

/**
 * Properties have several capabilities i.e
 * 1. They can always have custom setters and getters
 *
 */
var name: String? = null
    get() = field?.uppercase()
    set(value){
        checkNotNull(value)
        field = value
    }

fun main(){
    name = "Sam"
    print(name)
}

open class SuperComputer {
    open val theAnswer: Long = 42
}

class AppleComputer: SuperComputer(){
    override val theAnswer: Long = 1_800_275_2273
}