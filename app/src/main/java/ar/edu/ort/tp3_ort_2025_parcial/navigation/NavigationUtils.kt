package ar.edu.ort.tp3_ort_2025_parcial.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

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
    )
}

data class BottomMenuContent(
    val icon: ImageVector,
    val iconFull: ImageVector,
    val route: String,
    val section: String
)

@Composable
fun getBottomBarContent(): List<BottomMenuContent> {
    return listOf(
        BottomMenuContent(
            ImageVector.vectorResource(id = R.drawable.home_icon),
            ImageVector.vectorResource(id = R.drawable.home_icon_full),
            Screens.Welcome.screen,
            stringResource(R.string.home)
        ),
        BottomMenuContent(
            ImageVector.vectorResource(id = R.drawable.chat_icon),
            ImageVector.vectorResource(id = R.drawable.chat_icon_full),
            Screens.Login.screen,
            stringResource(R.string.chat)
        ),
    )
}

fun getSectionForRoute(route: String?): String? {
    return when (route) {
        Screens.Welcome.screen -> "welcome"
        Screens.Login.screen -> "login"
        else -> null
    }
}