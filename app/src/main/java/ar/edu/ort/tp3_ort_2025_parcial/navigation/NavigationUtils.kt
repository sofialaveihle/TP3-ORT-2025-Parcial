package ar.edu.ort.tp3_ort_2025_parcial.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

// Top Bar
fun showTopBar(
    currentRoute: String?
): Boolean {
    val noTopBarRoutes = getNoTopBarRoutes()
    return currentRoute !in noTopBarRoutes
}

private fun getNoTopBarRoutes(): List<String> {
    return listOf(
        Screens.Welcome.screen,
        Screens.Login.screen,
        Screens.Home.screen,
        Screens.Register.screen,
        Screens.ForgotPassword.screen,
        Screens.NewPassword.screen,
        Screens.ProfileUser.screen,
        Screens.ProfileSeller.screen,
        Screens.PaymentSuccess.screen
    )
}

// Bottom Bar
data class BottomMenuContent(
    val icon: ImageVector,
    val iconFull: ImageVector,
    val route: String,
    val section: String,
    val desc: String
)

@Composable
fun getBottomBarContent(): List<BottomMenuContent> {
    return listOf(
        BottomMenuContent(
            ImageVector.vectorResource(id = R.drawable.home_icon),
            ImageVector.vectorResource(id = R.drawable.home_icon_full),
            Screens.Home.screen,
            stringResource(R.string.home),
            stringResource(R.string.home_desc)
        ),
        BottomMenuContent(
            ImageVector.vectorResource(id = R.drawable.time_circle_icon),
            ImageVector.vectorResource(id = R.drawable.time_circle_icon_full),
            Screens.Time.screen,
            stringResource(R.string.empty_time),
            stringResource(R.string.empty_desc)
        ),
        BottomMenuContent(
            ImageVector.vectorResource(id = R.drawable.bag_icon),
            ImageVector.vectorResource(id = R.drawable.bag_icon_full),
            Screens.Cart.screen,
            stringResource(R.string.bag),
            stringResource(R.string.bag_desc)
        ),
        BottomMenuContent(
            ImageVector.vectorResource(id = R.drawable.profile_icon),
            ImageVector.vectorResource(id = R.drawable.profile_icon_full),
            Screens.ProfileUser.screen,
            stringResource(R.string.profile),
            stringResource(R.string.profile_desc)
        ),
    )
}

fun getSectionForRoute(route: String?): String? {
    return when (route) {
        Screens.Welcome.screen -> "welcome"
        Screens.Login.screen -> "login"
        Screens.Home.screen -> "home"
        Screens.ProfileUser.screen -> "profileUser"
        Screens.Cart.screen -> "cart"
        Screens.Time.screen -> "time"
        else -> null
    }
}

fun showBottomBar(
    currentRoute: String?
): Boolean {
    val noTopBarRoutes = getNoBottomBarRoutes()
    return currentRoute !in noTopBarRoutes
}

private fun getNoBottomBarRoutes(): List<String> {
    return listOf(
        Screens.Welcome.screen,
        Screens.HomeNotifications.screen,
        Screens.Search.screen,
        Screens.Login.screen,
        Screens.Register.screen,
        Screens.ForgotPassword.screen,
        Screens.NewPassword.screen,
        Screens.ProfileSeller.screen,
        Screens.SettingsPage.screen,
        Screens.ProfileUserEdit.screen,
        Screens.Address.screen,
        Screens.Notification.screen,
        Screens.Privacy.screen,
        Screens.Security.screen,
        Screens.ContactUs.screen,
        Screens.Faq.screen,
        Screens.ChangePassword.screen,
        Screens.ChangeEmail.screen,
        Screens.PaymentSuccess.screen,
        Screens.AddPaymentMethod.screen,
        Screens.ChoosePaymentMethod.screen
    )
}