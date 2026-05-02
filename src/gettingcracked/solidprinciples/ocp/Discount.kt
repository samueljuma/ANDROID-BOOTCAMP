package gettingcracked.solidprinciples.ocp

interface Discount{
    fun calculate(): Double
}

class StudentDiscount: Discount{
    override fun calculate() = 0.1
}

class VIPDiscount: Discount{
    override fun calculate() = 0.2
}

class DefaultDiscount: Discount{
    override fun calculate() = 0.0
}