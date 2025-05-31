package ar.edu.ort.tp3_ort_2025_parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.tp3_ort_2025_parcial.component.bar.BottomAppBar
import ar.edu.ort.tp3_ort_2025_parcial.component.bar.TopAppBar
import ar.edu.ort.tp3_ort_2025_parcial.navigation.showBottomBar
import ar.edu.ort.tp3_ort_2025_parcial.navigation.showTopBar
import ar.edu.ort.tp3_ort_2025_parcial.screen.login.Login
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ChangeEmail
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ChangePassword
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
                val mainViewModel: MainViewModel = viewModel()

                // Ruta actual
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                LaunchedEffect(navController) {
                    navController.currentBackStackEntryFlow.collect { entry ->
                        val route = entry.destination.route
                        mainViewModel.updateSectionFromRoute(route)
                    }
                }

                Scaffold(
                    topBar = {
                        if (showTopBar(currentRoute)) {
                            TopAppBar(
                                topBarViewModel = mainViewModel,
                                navController = navController
                            )
                        }
                    },
                    bottomBar = {
                        if (showBottomBar(currentRoute)) {
                            BottomAppBar(
                                navController = navController,
                                viewModel = mainViewModel,
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Screens.Welcome.screen
                    ) {
                        composable(Screens.Welcome.screen) { Welcome(navController) }
                        composable(Screens.Login.screen) { Login(navController) }
                        composable(Screens.ProfileSeller.screen) { ProfileSeller(navController) }
                        composable(Screens.ProfileUser.screen) { ProfileUser(navController) }
                        composable(Screens.ProfileUserEdit.screen) { ProfileUserEdit(navController, mainViewModel) }
                        composable(Screens.SettingsPage.screen) { SettingsPage(navController) }
                        composable(Screens.Security.screen) { Security(navController) }
                        composable(Screens.Privacy.screen) { Privacy() }
                        composable(Screens.Notification.screen) { Notification(viewModel) }
                        composable(Screens.Faq.screen) { Faq() }
                        composable(Screens.ChangePassword.screen) { ChangePassword(navController, mainViewModel) }
                        composable(Screens.ChangeEmail.screen) { ChangeEmail(navController, mainViewModel) }
                    }
                }
            }
        }
    }
}