package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.model.user.LoginRequest
import ar.edu.ort.tp3_ort_2025_parcial.model.user.LoginResponse
import ar.edu.ort.tp3_ort_2025_parcial.model.user.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ILoginAPI {
    @POST("auth/login")
    suspend fun login(@Body credentials: LoginRequest): Response<LoginResponse>

    @GET("/auth/me")
    suspend fun me(@Header("Authorization") token: String): Response<UserModel>
}