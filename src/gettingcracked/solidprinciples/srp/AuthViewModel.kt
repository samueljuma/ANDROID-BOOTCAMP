package gettingcracked.solidprinciples.srp


data class UserInfo(val id: String)

class LoginUseCase{
    fun login(userInfo: UserInfo): String = "success"
}

class ValidateInputUseCase{
    fun validate(input: UserInfo): Boolean = true
}

class SaveTokenUseCase{
    fun save(token: String){}
}

class Navigator{
    fun goToHome(){}
}

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val validateInput: ValidateInputUseCase,
    private val saveToken: SaveTokenUseCase,
    private val navigator: Navigator
) {

    fun onLoginClicked(userInfo: UserInfo) {
        val isValid = validateInput.validate(userInfo)
        if (!isValid) return

        val token = loginUseCase.login(userInfo)
        saveToken.save(token)
        navigator.goToHome()
    }
}
