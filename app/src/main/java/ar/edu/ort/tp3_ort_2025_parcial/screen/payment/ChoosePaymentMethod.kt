package ar.edu.ort.tp3_ort_2025_parcial.screen.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button3
import ar.edu.ort.tp3_ort_2025_parcial.component.radiobutton.RadioButton1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title2
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ChoosePaymentMethodScreen(navController: NavController, mainViewModel: MainViewModel) {
    var selectedMethod by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        mainViewModel.setTopBar("Payment Method")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

            Title2(
                text = stringResource(R.string.choose_payment_method_title),
                textAlign = TextAlign.Start,
            )

            val paypalLabel = stringResource(R.string.paypal_radio_button)
            val bankLabel = stringResource(R.string.bank_transfer_radio_button)

            RadioButton1(
                label = paypalLabel,
                selected = selectedMethod == paypalLabel,
                onSelect = { selectedMethod = paypalLabel }
            )

            RadioButton1(
                label = bankLabel,
                selected = selectedMethod == bankLabel,
                onSelect = { selectedMethod = bankLabel }
            )
        }

        Button1(
            text = stringResource(R.string.checkout_button),
            onClick = { navController.navigate(Screens.PaymentSuccess.screen) },
            isSelected = selectedMethod.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )
    }
}