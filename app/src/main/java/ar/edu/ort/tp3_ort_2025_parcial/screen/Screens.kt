package ar.edu.ort.tp3_ort_2025_parcial.screen

sealed class Screens(val screen: String) {
    data object Welcome : Screens("welcome")
    data object Login : Screens("login")

    // Profile
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
    data object PaymentSuccess : Screens("paymentSuccess")
    data object AddPaymentMethod : Screens("addPaymentMethod")
    data object ChoosePaymentMethod : Screens("choosePaymentMethod")

    // Homepage
    data object Home : Screens("home")
    data object HomeNotifications : Screens("home_notification")
    data object BestSeller: Screens("best_seller")
    data object Search: Screens("search")
    data object ProductDetail: Screens("product_detail")
    data object Cart: Screens("cart")

    //Time (empty screen, second button of bottom bar)
    data object Time : Screens("time")

}