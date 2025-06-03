package ar.edu.ort.tp3_ort_2025_parcial.network

import ar.edu.ort.tp3_ort_2025_parcial.model.user.UserModel
import ar.edu.ort.tp3_ort_2025_parcial.model.user.LoginRequest
import ar.edu.ort.tp3_ort_2025_parcial.model.user.LoginResponse
import ar.edu.ort.tp3_ort_2025_parcial.service.ILoginAPI
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceLogin
import javax.inject.Inject

data class LoginRetrofit
@Inject
constructor(private val service: ILoginAPI) : IServiceLogin {

    override suspend fun login(username: String, password: String): LoginResponse? {
        val credentials = LoginRequest(username, password)
        val response = service.login(credentials)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    override suspend fun me(token: String): UserModel? {
        val bearer = "Bearer $token"
        val response = service.me(bearer)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}
