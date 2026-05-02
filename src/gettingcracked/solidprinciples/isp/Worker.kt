package gettingcracked.solidprinciples.isp

/**
 * Clients should not be forced to depend on methods they do not use
 * Don’t create fat interfaces
 */

/**
 * DONE WRONG
 */

interface Worker1{
    fun work()
    fun eat()
}

class Robot1: Worker1{
    override fun eat(){} // Robots Don't Eat
    override fun work(){}
}

/**
 * DONE RIGHT
 */

interface Workable{
    fun work()
}

interface Eatable{
    fun eat()
}

class Robot: Workable{
    override fun work(){}
}


class Human: Workable, Eatable {
    override fun work(){}
    override fun eat(){}
}