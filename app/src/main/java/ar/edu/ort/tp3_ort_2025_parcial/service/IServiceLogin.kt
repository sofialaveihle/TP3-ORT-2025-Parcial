package ar.edu.ort.tp3_ort_2025_parcial.service;


import ar.edu.ort.tp3_ort_2025_parcial.model.user.LoginResponse
import ar.edu.ort.tp3_ort_2025_parcial.model.user.UserModel;


interface IServiceLogin {
    suspend fun login(username: String, password: String): LoginResponse?
    suspend fun me(token: String): UserModel?
}
