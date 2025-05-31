package ar.edu.ort.tp3_ort_2025_parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.tp3_ort_2025_parcial.screen.login.Login
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.HomeScreen
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.LocationScreen
import ar.edu.ort.tp3_ort_2025_parcial.screen.welcome.Welcome
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.TP3ORT2025ParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP3ORT2025ParcialTheme {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Screens.Home.screen
                    ) {
                        composable(Screens.Welcome.screen) { Welcome(navController) }
                        composable(Screens.Login.screen) { Login(navController) }
                        composable(Screens.Home.screen) { HomeScreen(navController) }
                        composable(Screens.Location.screen) { LocationScreen() }
                    }
                }
            }
        }
    }
}