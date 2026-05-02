package gettingcracked.solidprinciples.srp

/**
 * STK Push initiation
 * Handling callback response
 * Updating payment status
 * Notifying user (SMS or UI)
 */

data class MpesaCallbackResponse(val result: String, val phone: String)
enum class PaymentStatus {
    SUCCESS, FAILED, PENDING
}
enum class NotificationChannel{
    SMS, EMAIL, WHATSAPP
}

class InitiateSTKPush(){
    fun initiate(){}
}

class MpesaCallbackHandler {
    fun handle(response: MpesaCallbackResponse) {}
}

class PaymentStatusUpdater {
    fun update(paymentId: String, status: PaymentStatus) {}
}


class SmsNotifier(){
    fun notify(message: String, phone: String) {}
}

class MpesaPaymentInitiator(
    private val stkPush: InitiateSTKPush
) {
    fun initiate(phone: String, amount: Double) {
        stkPush.initiate()
    }
}

class MpesaCallbackProcessor(
    private val statusUpdater: PaymentStatusUpdater,
    private val notifier: SmsNotifier
) {
    fun process(response: MpesaCallbackResponse) {
        val status = mapToStatus(response)
        statusUpdater.update(response.result, status)

        if (status == PaymentStatus.SUCCESS) {
            notifier.notify("Payment successful", response.phone)
        }
    }
}

internal fun mapToStatus(response: MpesaCallbackResponse): PaymentStatus {
    return PaymentStatus.SUCCESS
}