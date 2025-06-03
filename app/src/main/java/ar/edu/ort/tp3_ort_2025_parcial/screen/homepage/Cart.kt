package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.card.CartInfoCard
import ar.edu.ort.tp3_ort_2025_parcial.component.card.CartItemCard
import ar.edu.ort.tp3_ort_2025_parcial.component.card.SwipeCartItemCard
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun Cart(
    viewmodel: MainViewModel
){
    val cart = viewmodel.cart
    val title = stringResource(R.string.cart)
    LaunchedEffect(Unit) {
        viewmodel.setTopBar(title)
        viewmodel.loadCart()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        cart?.products?.forEach { item ->
            SwipeCartItemCard(
                title = item.title,
                total = item.total,
                quantity = item.quantity,
                thumbnail = item.thumbnail,
                onDelete = {}
            )
        }

        CartInfoCard(
            cantItems = cart?.totalProducts,
            total = cart?.total,
            discount = cart?.discountedTotal,
        )

        Button1(
            text = "Checkout",
            onClick = {},
            modifier = Modifier
        )
    }
}