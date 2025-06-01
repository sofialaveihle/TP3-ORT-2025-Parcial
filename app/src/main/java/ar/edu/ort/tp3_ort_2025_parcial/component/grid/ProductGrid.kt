package ar.edu.ort.tp3_ort_2025_parcial.component.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.card.ProductCard
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

@Composable
fun ProductGrid(
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        items(productList) { product ->
            ProductCard(
                product = product,
                //Modificar para que navegue a screen de detalle de producto
                onClick = { navController.navigate(Screens.Welcome.screen) }
            )
        }

    }
}

//Con fines de test, entiendo que luego será conectandonos a la API
data class Product(
    val name: String,
    val price: String,
    val imageRes: Int
)

val productList = listOf(
    Product("RC Kitten", "$20.99", R.drawable.product_1),
    Product("RC Persian", "$25.49", R.drawable.product_1),
    Product("RC Adult", "$15.30", R.drawable.product_1),
    Product("RC Indoor", "$18.00", R.drawable.product_1),
    Product("RC Outdoor", "$15.30", R.drawable.product_1),
    Product("RC Diabetic", "$18.00", R.drawable.product_1)
)