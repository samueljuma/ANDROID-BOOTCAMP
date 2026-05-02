package gettingcracked.solidprinciples.dip

interface AuthAPI{
    fun login(): String
}

class AuthApiImpl: AuthAPI{
    override fun login(): String {
        return "login"
    }
}

interface TokenStore{
    fun save(token: String)
}

class TokenStoreImpl: TokenStore{
    override fun save(token: String) {}
}

class AuthService(
    private val api: AuthAPI,
    private val tokenStore: TokenStore
){
    fun login(){
        val token = api.login()
        tokenStore.save(token)
    }
}

fun main(){
    val tokenStore = TokenStoreImpl()
    val api = AuthApiImpl()
    val authService = AuthService(api, tokenStore)
    authService.login()
}