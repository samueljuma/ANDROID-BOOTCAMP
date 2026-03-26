package effectivekotlinbymarcinmoskala.safety

class InsufficientBalance: Exception()

class BankAccount{
    var balance = 0.0
        private set

    fun deposit(amount:Double){
        balance += amount
    }

    @Throws(InsufficientBalance::class)
    fun withdraw(amount: Double){
        if(balance < amount) throw InsufficientBalance()
        balance -= amount
    }
}

fun main(){
    val account = BankAccount()
    println(account.balance)
    account.deposit(100.0)
    println(account.balance)
    account.withdraw(10.0)
    println(account.balance)
}