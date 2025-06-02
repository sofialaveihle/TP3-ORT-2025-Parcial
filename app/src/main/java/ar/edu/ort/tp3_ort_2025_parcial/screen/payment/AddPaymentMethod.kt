package ar.edu.ort.tp3_ort_2025_parcial.screen.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
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
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button3
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title2
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun AddPaymentMethodScreen(navController: NavController, mainViewModel: MainViewModel) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        val screenHeight = maxHeight

        var cardNumber by remember { mutableStateOf("") }
        var cardName by remember { mutableStateOf("") }
        var expired by remember { mutableStateOf("") }
        var cvv by remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            mainViewModel.setTopBar("Payment Method")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = screenHeight * 0.05f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

                Title2(
                    text = stringResource(R.string.add_new_payment_title),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )

                Input1(
                    placeHolder = stringResource(R.string.card_number_title_button),
                    value = cardNumber,
                    onValueChange = { cardNumber = it },
                    isPassword = false
                )
                Input1(
                    placeHolder = stringResource(R.string.card_name_title_button),
                    value = cardName,
                    onValueChange = { cardName = it },
                    isPassword = false
                )

                Input1(
                    placeHolder = stringResource(R.string.expired_title_button),
                    value = expired,
                    onValueChange = { expired = it },
                    isPassword = false

                )
                Input1(
                    placeHolder = stringResource(R.string.cvv_title_button),
                    value = cvv,
                    onValueChange = { cvv = it },
                    isPassword = true
                )

            }

            Button3(
                text = "Save",
                onClick = { /* acción */ },
                isSelected = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
        }
    }
}