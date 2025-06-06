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
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.card.CartInfoCard
import ar.edu.ort.tp3_ort_2025_parcial.component.card.SwipeCartItemCard
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.CartViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel

@Composable
fun Cart(
    navController: NavController,
    cartViewmodel: CartViewModel,
    topAppViewModel: TopAppViewModel
){
    val cart = cartViewmodel.cart
    val title = stringResource(R.string.cart)
    LaunchedEffect(Unit) {
        topAppViewModel.setTopBar(title)
        cartViewmodel.loadCart()
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
            text = stringResource(R.string.checkout_button_text),
            onClick = { navController.navigate(Screens.AddPaymentMethod.screen) },
            modifier = Modifier,
            isSelected = true
        )
    }
}