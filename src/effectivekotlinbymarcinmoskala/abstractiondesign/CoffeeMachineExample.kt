package effectivekotlinbymarcinmoskala.abstractiondesign

/**
 * `Single Level of Abstraction principle` that states that: Each function should be
 *  written in terms of a single level of abstraction.
 */


/**
 * The Wrong Way
 * Having everything thrown in Make coffee
 */
class CoffeeMachine {
    fun makeCoffee(){
        //
    }
}

/**
 * The Right Way
 * Abstracting individual operations
 *
 * This also improves readability
 */
class CoffeeMachine1 {
    fun makeCoffee(){
        boilWater()
        brewCoffee()
        pourCoffee()
        pourMilk()
    }

    private fun boilWater(){}
    private fun brewCoffee(){}
    private fun pourMilk() {}
    private fun pourCoffee() {}

}