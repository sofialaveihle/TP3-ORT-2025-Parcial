package ar.edu.ort.tp3_ort_2025_parcial.model.user

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    @SerializedName("username") val email: String,
    @SerializedName("password") val password: String
)
