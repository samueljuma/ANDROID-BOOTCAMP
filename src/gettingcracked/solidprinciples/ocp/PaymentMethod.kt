package gettingcracked.solidprinciples.ocp

interface PaymentType {
    fun pay()
}

interface Refundable {
    fun refund()
}

class MpesaPay : PaymentType, Refundable {
    override fun pay() {}
    override fun refund() {}
}

class CashPay : PaymentType {
    override fun pay() {}
}

class CardPay : PaymentType, Refundable {
    override fun pay() {}
    override fun refund() {}
}

class PayService(
    private val paymentType: PaymentType
) {
    fun process() {
        paymentType.pay()
    }
}

class RefundService(
    private val refundable: Refundable
){
    fun process() {
        refundable.refund()
    }
}

private fun processRefund(refundable: Refundable) {
    refundable.refund()
}

class PaymentsProcessing(
    private val payService: PayService = PayService(MpesaPay()),
    private val refundService: RefundService = RefundService(MpesaPay())
){
    fun pay() = payService.process()
    fun refund() = refundService.process()
}