package effectivekotlinbymarcinmoskala.reusability

import kotlin.properties.Delegates

/**
 * Property delegation gives a universal way to extract property behavior
 * 1. [lazy] property , 2. [Delegates.observable]
 */

fun main(){
    val value: Int by lazy { createValue()}
}


private fun createValue(): Int {
    return 1
}

data class Item(val id: Int, val name: String)

var items: List<Item> by
    Delegates.observable(listOf()){_,_,_ ->
        notifyDataSetChanged()
    }

var key: String? by
Delegates.observable(null){_, oldValue, newValue ->
    println("key chnaged from $oldValue to $newValue")
}

fun notifyDataSetChanged() {
    TODO("Not yet implemented")
}
