package ar.edu.ort.tp3_ort_2025_parcial.component.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.component.card.ProductCard
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1
import ar.edu.ort.tp3_ort_2025_parcial.model.Product
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

@Composable
fun ProductGrid(
    navController: NavController,
    productList: List<Product>,
    modifier: Modifier = Modifier
) {
    if (productList.isEmpty()) {
        Text1(
            "No hay productos disponibles",
            modifier = Modifier.padding(horizontal = 20.dp),
            textAlign = TextAlign.Center
        )
    } else {

        val repeatedList = if (productList.size < 10) {
            List(10) { index -> productList[index % productList.size] }
        } else {
            productList
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(5.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = modifier.padding(horizontal = 20.dp)
        ) {
            items(repeatedList) {
                ProductCard(
                    product = it,
                    //Modificar para que navegue a screen de detalle de producto
                    onClick = { navController.navigate(Screens.Welcome.screen) }
                )
            }
        }
    }
}
