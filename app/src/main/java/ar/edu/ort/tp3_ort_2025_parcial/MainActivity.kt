package ar.edu.ort.tp3_ort_2025_parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ar.edu.ort.tp3_ort_2025_parcial.component.bar.BottomAppBar
import ar.edu.ort.tp3_ort_2025_parcial.component.bar.TopAppBar
import ar.edu.ort.tp3_ort_2025_parcial.navigation.showBottomBar
import ar.edu.ort.tp3_ort_2025_parcial.navigation.showTopBar
import ar.edu.ort.tp3_ort_2025_parcial.screen.login.Login
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.screen.empty.Time
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.BestSeller
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.Cart
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.HomeNotification
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.HomeScreen
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.ProductDetail
import ar.edu.ort.tp3_ort_2025_parcial.screen.homepage.Search
import ar.edu.ort.tp3_ort_2025_parcial.screen.login.ForgotPassword
import ar.edu.ort.tp3_ort_2025_parcial.screen.login.NewPassword
import ar.edu.ort.tp3_ort_2025_parcial.screen.login.Register
import ar.edu.ort.tp3_ort_2025_parcial.screen.payment.AddPaymentMethodScreen
import ar.edu.ort.tp3_ort_2025_parcial.screen.payment.ChoosePaymentMethodScreen
import ar.edu.ort.tp3_ort_2025_parcial.screen.payment.PaymentSuccessScreen
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ChangeEmail
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ChangePassword
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ProfileSeller
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ProfileUser
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ProfileUserEdit
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.SettingsPage
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Address
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Notification
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Privacy
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Security
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.ContactUs
import ar.edu.ort.tp3_ort_2025_parcial.screen.profile.Faq
import ar.edu.ort.tp3_ort_2025_parcial.screen.welcome.Welcome
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.TP3ORT2025ParcialTheme
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.BottomBarViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.CartViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.HomepageViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.LoginViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.NotificationViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.ProductViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.SearchBarViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            TP3ORT2025ParcialTheme {

                // Nav Controller
                val navController = rememberNavController()

                // View Models
                val mainViewModel: MainViewModel = viewModel()
                val notificationViewModel: NotificationViewModel = viewModel()
                val searchBarViewModel: SearchBarViewModel = viewModel()
                val bottomBarViewModel: BottomBarViewModel = viewModel()
                val topAppViewModel: TopAppViewModel = viewModel()
                val homepageViewModel: HomepageViewModel = viewModel()
                val cartViewModel: CartViewModel = hiltViewModel()
                val productViewModel: ProductViewModel = hiltViewModel()
                val loginViewModel: LoginViewModel = hiltViewModel()

                productViewModel.loadProducts()
                cartViewModel.loadCart()

                // Ruta actual
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                LaunchedEffect(navController) {
                    navController.currentBackStackEntryFlow.collect { entry ->
                        val route = entry.destination.route
                        bottomBarViewModel.updateSectionFromRoute(route)
                    }
                }

                Scaffold(
                    topBar = {
                        if (showTopBar(currentRoute)) {
                            TopAppBar(
                                topBarViewModel = topAppViewModel,
                                navController = navController
                            )
                        }
                    },
                    bottomBar = {
                        if (showBottomBar(currentRoute)) {
                            BottomAppBar(
                                navController = navController,
                                bottomBarViewModel = bottomBarViewModel,
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Screens.Welcome.screen
                    ) {
                        // Welcome
                        composable(Screens.Welcome.screen) { Welcome(navController) }

                        // Log in
                        composable(Screens.Login.screen) { Login(navController, mainViewModel, loginViewModel) }
                        composable(Screens.Register.screen) { Register(navController) }
                        composable(Screens.ForgotPassword.screen) { ForgotPassword(navController) }
                        composable(Screens.NewPassword.screen) { NewPassword(navController) }

                        // Home
                        composable(Screens.Home.screen) { HomeScreen(navController, homepageViewModel, productViewModel, searchBarViewModel) }
                        composable(Screens.BestSeller.screen) { BestSeller(navController, productViewModel, topAppViewModel) }
                        composable(Screens.HomeNotifications.screen) { HomeNotification(homepageViewModel, topAppViewModel) }
                        composable(Screens.Search.screen) { Search(searchBarViewModel, topAppViewModel) }
                        composable(
                            route = "${Screens.ProductDetail.screen}/{productId}",
                            arguments = listOf(navArgument("productId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val productId = backStackEntry.arguments?.getInt("productId")
                            ProductDetail(productId, navController, productViewModel, topAppViewModel)
                        }
                        composable(Screens.Cart.screen) { Cart(navController, cartViewModel, topAppViewModel) }

                        // Account
                        composable(Screens.ProfileSeller.screen) { ProfileSeller(navController, productViewModel) }
                        composable(Screens.ProfileUser.screen) { ProfileUser(navController, productViewModel ,mainViewModel) }
                        composable(Screens.ProfileUserEdit.screen) { ProfileUserEdit(navController, mainViewModel, topAppViewModel) }
                        composable(Screens.SettingsPage.screen) { SettingsPage(navController, topAppViewModel) }
                        composable(Screens.Address.screen) { Address(topAppViewModel) }
                        composable(Screens.Notification.screen) { Notification(topAppViewModel, notificationViewModel) }
                        composable(Screens.Privacy.screen) { Privacy(topAppViewModel) }
                        composable(Screens.Security.screen) { Security(navController, topAppViewModel) }
                        composable(Screens.ContactUs.screen) { ContactUs(topAppViewModel) }
                        composable(Screens.Faq.screen) { Faq(topAppViewModel) }
                        composable(Screens.ChangePassword.screen) { ChangePassword(navController, topAppViewModel) }
                        composable(Screens.ChangeEmail.screen) { ChangeEmail(navController, topAppViewModel) }
                        composable(Screens.PaymentSuccess.screen) { PaymentSuccessScreen(navController) }
                        composable(Screens.AddPaymentMethod.screen) { AddPaymentMethodScreen(navController, topAppViewModel) }
                        composable(Screens.ChoosePaymentMethod.screen){ ChoosePaymentMethodScreen(navController, topAppViewModel) }
                        composable(Screens.Time.screen) { Time(topAppViewModel) }
                    }
                }
            }
        }
    }
}