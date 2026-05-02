package gettingcracked.solidprinciples.ocp

/**
 * Software entities should be:
 * - Open for extension
 * - Closed for modification
 *
 * i.e You should be able to add new behavior without changing existing code
 */

/*
 * Wrong Way
 */
class PaymentServiceWrong {

    fun pay(method: String) {
        if (method == "MPESA") {
            // mpesa logic
        } else if (method == "CASH") {
            // cash logic
        } else if (method == "CARD") {
            // new requirement 😭 → modify this class
        }
    }
}

/*
 * Right Way
 */

interface PaymentMethod {
    fun pay()
}

class MpesaPayment: PaymentMethod{
    override fun pay() {}
}

class CashPayment: PaymentMethod{
    override fun pay() {}
}

class CardPayment: PaymentMethod{
    override fun pay() {}
}

class PaymentService(
    private val paymentMethod: PaymentMethod
){
    fun process(){
        paymentMethod.pay()
    }
}