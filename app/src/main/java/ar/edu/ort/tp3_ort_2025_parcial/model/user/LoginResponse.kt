package ar.edu.ort.tp3_ort_2025_parcial.model.user

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
)
