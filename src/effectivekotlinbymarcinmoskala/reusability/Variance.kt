package effectivekotlinbymarcinmoskala.reusability

/**
 * In Kotlin:
 * • Type parameter of List and Set are covariant (out modifier)
 * so for instance, we can pass any list where List<Any> is
 * expected. Also, the type parameter representing value type
 * in Map is covariant (out modifier). Type parameters of Array,
 * MutableList, MutableSet, MutableMap are invariant (no variance modifier).
 * • In function types parameter types are contravariant (in modifier)
 * and return type is covariant (out modifier).
 * • We use covariance (out modifier) for types that are only
 * returned (produced or exposed).
 * • We use contravariance (in modifier) for types that are only accepted.
 */


class Box<in T> {
    private var value: T? = null

    fun set(value: T){
        this.value = value
    }

    private fun get(): T = value ?: error("Value not set")
}