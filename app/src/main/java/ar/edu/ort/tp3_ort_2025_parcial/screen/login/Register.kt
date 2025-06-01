package ar.edu.ort.tp3_ort_2025_parcial.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import ar.edu.ort.tp3_ort_2025_parcial.component.checkbox.Checkbox
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1Clickable
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    val navController = rememberNavController()
    Register(navController = navController)
}

@Composable
fun Register(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var termsAndConditions by remember { mutableStateOf(false) }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp)
    ) {
        val screenHeight = maxHeight
        val screenWidth = maxWidth
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
                text = stringResource(R.string.register_login_title),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.04f))
            Text1(
                text = stringResource(R.string.under_title_text),
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.04f))
            Input1(stringResource(R.string.full_name_place_holder), fullName, onValueChange = { fullName = it }, false)
            Spacer(modifier = Modifier.padding(screenHeight * 0.02f))
            Input1(stringResource(R.string.email_place_holder), email, onValueChange = { email = it }, false)
            Spacer(modifier = Modifier.padding(screenHeight * 0.02f))
            Input1(stringResource(R.string.password_place_holder), password, onValueChange = { password = it }, true)
            Spacer(modifier = Modifier.padding(screenHeight * 0.03f))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    onCheckedChange = { termsAndConditions = it },
                    checked = termsAndConditions
                )
                Spacer(modifier = Modifier.width(screenWidth * 0.02f))
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text1(stringResource(R.string.terms_conditions_1))
                    Text1Clickable(stringResource(R.string.terms_conditions_link_1)) { }
                    Text1(stringResource(R.string.terms_conditions_2))
                    Text1Clickable(stringResource(R.string.terms_conditions_link_2)) { }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.padding(screenHeight * 0.04f)) {
                Text1(text = stringResource(R.string.have_an_account))
                Text1Clickable(text = stringResource(R.string.login)) {
                    navController.navigate(Screens.Login.screen)
                }
            }
            Button1(
                onClick = { navController.navigate(Screens.ForgotPassword.screen) }, // TODO not push test
                text = stringResource(R.string.get_started_button_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = screenHeight * 0.03f)
            )
        }
    }
}