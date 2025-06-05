package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.grid.ProductGrid
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.HomepageViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.ProductViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel

@Composable
fun BestSeller(
    navController: NavController,
    productViewModel: ProductViewModel,
    topbarViewModel: TopAppViewModel
){
    val title = stringResource(R.string.best_seller)
    LaunchedEffect(Unit) {
        topbarViewModel.setTopBar(title)
    }

    val products = productViewModel.products

    LaunchedEffect(Unit) {
        productViewModel.loadProducts()
    }

    ProductGrid(
        navController = navController,
        productList = products
    )
}