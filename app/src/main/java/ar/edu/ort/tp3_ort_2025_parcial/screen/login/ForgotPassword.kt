package ar.edu.ort.tp3_ort_2025_parcial.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1Clickable
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    val navController = rememberNavController()
    Register(navController = navController)
}

@Composable
fun ForgotPassword(navController: NavController) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp)
    ) {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title1(
                text = stringResource(R.string.forgot_password_login_title),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start))
            Spacer(modifier = Modifier.padding(32.dp))
            Text1(
                text = stringResource(R.string.under_title_text),
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Input1(stringResource(R.string.email_place_holder), email, onValueChange = { email = it }, false)

            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.padding(bottom = 32.dp)) {
                Text1(text = stringResource(R.string.have_an_account))
                Text1Clickable(text = stringResource(R.string.login)) {
                    navController.navigate(Screens.Login.screen)
                }
            }
            Button1(
                onClick = { navController.navigate(Screens.NewPassword.screen) },
                text = stringResource(R.string.next_button_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
        }
    }
}