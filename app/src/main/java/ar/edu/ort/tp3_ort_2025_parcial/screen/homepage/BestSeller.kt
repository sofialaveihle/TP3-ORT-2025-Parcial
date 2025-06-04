package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.grid.ProductGrid
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun BestSeller(
    navController: NavController,
    viewModel: MainViewModel
){
    val title = stringResource(R.string.best_seller)
    LaunchedEffect(Unit) {
        viewModel.setTopBar(title)
    }

    val products = viewModel.products

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    ProductGrid(
        navController = navController,
        productList = products
    )
}