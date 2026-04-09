package effectivekotlinbymarcinmoskala.reusability

/**
 * Avoid shadowing type parameters, and be careful when you see
 * that type parameter is shadowed. Unlike for other kinds of parameters,
 * it is not intuitive and might be highly confusing.
 */

interface Tree
class Birch: Tree
class Spruce: Tree

/**
 * The problem is that now Forest and addTree type parameters are
 * independent of each other:
 */
// This implementation shadows type parameters
class Forest<T: Tree> {
    fun <T: Tree> addTree(tree: T){
        //
    }
}

// Solution 1
class Forest1<T: Tree> {
    fun addTree(tree: T){
    }
}

// Solution 2
class Forest2<T: Tree> {
    fun <ST: T>addTree(tree: ST){
    }
}




fun main(){
    val forest = Forest<Birch>()
    forest.addTree(Birch())
    forest.addTree(Spruce())
    val forest1 = Forest1<Birch>()
    forest1.addTree(Birch())
//    forest1.addTree(Spruce()) // ERROR, type mismatch

    val forest2 = Forest2<Tree>()
    forest2.addTree(Birch())
    forest2.addTree(Spruce()) // ERROR, type mismatch
}