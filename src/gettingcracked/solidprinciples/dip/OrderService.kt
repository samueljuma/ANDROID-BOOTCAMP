package gettingcracked.solidprinciples.dip

/**
 * DONE WRONG
 */
class OrderRepositoryWrong{
    fun save(){}
}
class OrderServiceWrong {
    private val repository = OrderRepositoryWrong()
    fun placeOrder() {
        repository.save()
    }
}

/**
 * DONE RIGHT
 */
interface OrderRepository{
    fun save()
}

class OrderRepositoryImpl: OrderRepository{
    override fun save(){}
}

class OrderService(
    private val orderRepository: OrderRepository
){
    fun placeOrder(){
        orderRepository.save()
    }
}