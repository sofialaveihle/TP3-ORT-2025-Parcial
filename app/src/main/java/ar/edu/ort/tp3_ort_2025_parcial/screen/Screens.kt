package ar.edu.ort.tp3_ort_2025_parcial.screen

sealed class Screens(val screen: String) {
    data object Welcome : Screens("welcome")
    data object Login : Screens("login")
    data object Register : Screens("register")
    data object ForgotPassword : Screens("forgotPassword")
    data object NewPassword : Screens("newPassword")
}