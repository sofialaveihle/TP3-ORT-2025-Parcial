package ar.edu.ort.tp3_ort_2025_parcial.screen

sealed class Screens(val screen: String) {
    data object Welcome : Screens("welcome")
    data object Login : Screens("login")
    data object ProfileSeller : Screens("profileSeller")
    data object ProfileUser : Screens("profileUser")
    data object ProfileUserEdit : Screens("profileUserEdit")

}