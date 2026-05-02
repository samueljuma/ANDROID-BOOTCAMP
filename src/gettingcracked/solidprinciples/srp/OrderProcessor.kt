package gettingcracked.solidprinciples.srp

/**
 * A class should have only one reason to change.
 *
 * Not “one method”, not “one job” in a vague sense —
 * but one responsibility tied to a single concern.
 *
 * Think of it like this:
 *
 * If your class gets modified for different unrelated reasons, it’s doing too much.
 */
data class Order(val orderId: Int)

/**
 * Violates SRP
 */
class OrderProcessor {
    fun process(order: Order) { }
    fun saveToDb(order: Order) { }
    fun sendReceipt(order: Order) { }
}

/**
 * SRP followed
 */
class CheckoutService(
    private val processOrderUseCase: ProcessOrderUseCase,
    private val saveOrderToDbUseCase: SaveOrderToDbUseCase,
    private val sendReceiptUseCase: SendReceiptUseCase
){
    fun checkout(order: Order){
        processOrderUseCase.execute(order)
        saveOrderToDbUseCase.execute(order)
        sendReceiptUseCase.execute(order)
    }
}

class ProcessOrderUseCase(){
    fun execute(order: Order){}
}

class SaveOrderToDbUseCase(){
    fun execute(order: Order) { }
}

class SendReceiptUseCase(){
    fun execute(order: Order) { }
}

