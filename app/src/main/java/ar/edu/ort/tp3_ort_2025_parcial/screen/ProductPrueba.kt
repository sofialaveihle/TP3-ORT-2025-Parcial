package ar.edu.ort.tp3_ort_2025_parcial.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.component.grid.ProductGrid
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun ProductPrueba(
    navController: NavController,
    viewModel: MainViewModel = viewModel()
) {
    val products = viewModel.products

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    ProductGrid(
        navController = navController,
        productList = products
    )
}