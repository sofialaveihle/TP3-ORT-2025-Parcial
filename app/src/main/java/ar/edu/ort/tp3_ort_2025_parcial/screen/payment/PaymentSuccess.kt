package ar.edu.ort.tp3_ort_2025_parcial.screen.payment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray

@Preview(showBackground = true)
@Composable
fun PaymentSuccessPreview() {
    val navController = rememberNavController()
    PaymentSuccessScreen(navController = navController)
}


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun PaymentSuccessScreen(navController: NavController) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        val screenHeight = maxHeight

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = screenHeight * 0.05f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Title1(
                    text = stringResource(R.string.payment_success_title),
                    modifier = Modifier
                        .padding(top = screenHeight * 0.05f, end = 16.dp)
                        .align(Alignment.Start),
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = stringResource(R.string.payment_success_description),
                    color = Gray,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .width(327.dp)
                        .height(42.dp)
                )
            }
            // TODO Cambiar por pagina HOME, se dejo PaymentSuccess para tener algo
            Button1(
                text = stringResource(R.string.payment_success_button),
                onClick = { navController.navigate(Screens.PaymentSuccess.screen) },
                isSelected = true,
                modifier = Modifier
                    .width(327.dp)
                    .height(60.dp)
            )
        }
    }
}
