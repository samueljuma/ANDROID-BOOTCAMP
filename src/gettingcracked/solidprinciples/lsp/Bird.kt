package gettingcracked.solidprinciples.lsp

/**
 * A child class should not break expectations set by the parent
 *
 * If I replace a base type with a subtype,
 * the program should still behave correctly.
 */

open class BirdWrong {
    open fun fly(){}
}

class PenguinWrong(): BirdWrong(){
    override fun fly() {
        throw Exception("I can't fly")
    }
}

open class Bird {
    open fun feed(){}
}

open class FlyingBird: Bird(){
    open fun fly(){}
}

open class SwimmingBird: Bird(){
    open fun swim(){}
}

class Penguin: SwimmingBird() {
    override fun feed() {}
    override fun swim(){}
}

class WoodPecker: FlyingBird(){
    override fun fly() {}
}
