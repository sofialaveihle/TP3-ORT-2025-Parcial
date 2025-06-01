package ar.edu.ort.tp3_ort_2025_parcial.screen

sealed class Screens(val screen: String) {
    data object Welcome : Screens("welcome")
    data object Login : Screens("login")
    data object Register : Screens("register")
    data object ForgotPassword : Screens("forgotPassword")
    data object NewPassword : Screens("newPassword")
    data object ProfileSeller : Screens("profileSeller")
    data object ProfileUser : Screens("profileUser")
    data object ProfileUserEdit : Screens("profileUserEdit")
    data object SettingsPage : Screens("settingsPage")
    data object Address : Screens("address")
    data object Notification : Screens("notification")
    data object Privacy : Screens("privacy")
    data object Security : Screens("security")
    data object ContactUs : Screens("contactUs")
    data object Faq : Screens("faq")
    data object ChangePassword : Screens("changePassword")
    data object ChangeEmail : Screens("changeEmail")
}