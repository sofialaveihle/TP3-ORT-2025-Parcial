package ar.edu.ort.tp3_ort_2025_parcial.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title1(
                text = "Create New Account",
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Text1(
                text = "Water is life. Water is a basic human need. In various lines of life, humans need water.",
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Input1("Full Name", fullName, onValueChange = { fullName = it }, false)
            Spacer(modifier = Modifier.padding(16.dp))
            Input1("Email", email, onValueChange = { email = it }, false)
            Spacer(modifier = Modifier.padding(16.dp))
            Input1("Password", password, onValueChange = { password = it }, true)
            Spacer(modifier = Modifier.padding(25.dp))

            Row(modifier = Modifier) {
                Checkbox(onCheckedChange = { termsAndConditions = it }, checked = termsAndConditions)
                Spacer(modifier = Modifier.width(8.dp))
                Text1(text = "I agree to the ")
                Text1Clickable(text = "Terms of Service") { }
                Text1(text = " and ")
                Text1Clickable(text = "Privacy Policy") { }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.padding(bottom = 32.dp)) {
                Text1(text = "Have an account? ")
                Text1Clickable(text = "Login") {
                    navController.navigate(Screens.Login.screen)
                }
            }
            Button1(
                onClick = { navController.navigate(Screens.ForgotPassword.screen) }, // TODO not push test
                text = "Get Started",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
        }
    }
}