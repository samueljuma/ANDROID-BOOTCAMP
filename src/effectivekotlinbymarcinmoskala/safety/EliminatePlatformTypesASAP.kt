package effectivekotlinbymarcinmoskala.safety

fun platformType(){
    val value = JavaClass().value
    println(value.length) // NPE
}

fun statedType(){
    val value: String = JavaClass().value // NPE
    println(value.length)
}

interface UserRepo{
    fun getUserName() = JavaClass().value
}

class RepoImpl: UserRepo {
    override fun getUserName(): String? {
        return null
    }
}


fun main(){
//    platformType()
//    statedType()
    val repo: UserRepo = RepoImpl()
    val text: String = repo.getUserName()
    print("User name length is ${text.length}")
}