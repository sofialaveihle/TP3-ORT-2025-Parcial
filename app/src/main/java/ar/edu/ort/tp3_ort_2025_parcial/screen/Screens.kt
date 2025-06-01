package ar.edu.ort.tp3_ort_2025_parcial.screen

sealed class Screens(val screen: String) {
    data object Welcome : Screens("welcome")
    data object Login : Screens("login")

    // Homepage
    data object Home : Screens("home")
    data object Notification : Screens("notification")
}