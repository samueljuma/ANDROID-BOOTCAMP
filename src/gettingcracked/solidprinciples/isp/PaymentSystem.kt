package gettingcracked.solidprinciples.isp

/**
 * N/B Interfaces should read like capabilities
 * or roles, not actions or awkward adjectives
 */

interface Payable {
    fun pay(amount: Double)
}

interface Refundable {
    fun refund(amount: Double)
}

interface SupportsPartialPayment {
    fun payPartial(amount: Double)
}

interface SupportsRecurringPayment {
    fun schedule(amount: Double)
}

class OneTimePayment : Payable, Refundable, SupportsPartialPayment {
    override fun pay(amount: Double) {}
    override fun refund(amount: Double) {}
    override fun payPartial(amount: Double) {}
}

class SubscriptionPayment : Payable, SupportsRecurringPayment {
    override fun pay(amount: Double) {}
    override fun schedule(amount: Double) {}
}