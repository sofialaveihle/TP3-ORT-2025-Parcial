package ar.edu.ort.tp3_ort_2025_parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.tp3_ort_2025_parcial.screen.login.Login
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ProfileSeller
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ProfileUser
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ProfileUserEdit
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.SettingsPage
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Security
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Privacy
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Notification
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Faq
import ar.edu.ort.tp3_ort_2025_parcial.screen.welcome.Welcome
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.TP3ORT2025ParcialTheme
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel : MainViewModel by viewModels()
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
                        startDestination = Screens.Welcome.screen
                    ) {
                        composable(Screens.Welcome.screen) { Welcome(navController) }
                        composable(Screens.Login.screen) { Login(navController) }
                        composable(Screens.ProfileSeller.screen) { ProfileSeller(navController) }
                        composable(Screens.ProfileUser.screen) { ProfileUser(navController) }
                        composable(Screens.ProfileUserEdit.screen) { ProfileUserEdit(navController) }
                        composable(Screens.SettingsPage.screen) { SettingsPage(navController) }
                        composable(Screens.Security.screen) { Security(navController) }
                        composable(Screens.Privacy.screen) { Privacy() }
                        composable(Screens.Notification.screen) { Notification(viewModel) }
                        composable(Screens.Faq.screen) { Faq() }
                    }
                }
            }
        }
    }
}