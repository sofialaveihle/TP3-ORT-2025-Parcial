package ar.edu.ort.tp3_ort_2025_parcial.screen.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.*
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title2
import ar.edu.ort.tp3_ort_2025_parcial.model.CreditCard
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.CreditCardViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun AddPaymentMethodScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
    creditCardViewModel: CreditCardViewModel = hiltViewModel()
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        val screenHeight = maxHeight
        val creditCard by creditCardViewModel.creditCard.collectAsState()

        var cardNumber by remember { mutableStateOf("") }
        var cardName by remember { mutableStateOf("") }
        var expired by remember { mutableStateOf("") }
        var cvv by remember { mutableStateOf("") }

        // Set top bar
        LaunchedEffect(Unit) {
            mainViewModel.setTopBar("Payment Method")
        }

        // Cargar valores desde Room cuando estén listos
        LaunchedEffect(creditCard) {
            creditCard?.let {
                cardNumber = it.cardNumber
                cardName = it.cardName
                expired = it.expirationDate
            }
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

                InputCreditCardNumber(
                    value = cardNumber,
                    onValueChange = { cardNumber = it }
                )

                Input1(
                    placeHolder = stringResource(R.string.card_name_title_button),
                    value = cardName,
                    onValueChange = { cardName = it },
                    isPassword = false
                )

                InputExpirationDate(
                    value = expired,
                    onValueChange = { expired = it }
                )

                InputCVV(
                    value = cvv,
                    onValueChange = { cvv = it },
                    showError = cvv.isBlank()
                )
            }

            Button1(
                text = stringResource(R.string.save_button),
                onClick = {
                    val userId = 1
                    val newCard = CreditCard(
                        user_id = userId,
                        cardNumber = cardNumber,
                        cardName = cardName,
                        expirationDate = expired
                    )

                    if (creditCard != null) {
                        creditCardViewModel.updateCreditCard(newCard)
                    } else {
                        creditCardViewModel.saveCreditCard(newCard)
                    }

                    navController.navigate(Screens.ChoosePaymentMethod.screen)
                },
                isSelected = cardNumber.isNotBlank()
                        && cardName.isNotBlank()
                        && expired.isNotBlank()
                        && cvv.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
        }
    }
}
