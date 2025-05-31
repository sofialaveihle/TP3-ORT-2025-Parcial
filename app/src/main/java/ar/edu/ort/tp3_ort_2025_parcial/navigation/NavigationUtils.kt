package ar.edu.ort.tp3_ort_2025_parcial.navigation

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
//        Screens.Login.screen,
    )
}