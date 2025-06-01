package ar.edu.ort.tp3_ort_2025_parcial.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1Clickable
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

@Preview(showBackground = true)
@Composable
fun NewPasswordPreview() {
    val navController = rememberNavController()
    Register(navController = navController)
}

@Composable
fun NewPassword(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title1(text = "Create New\n Account")
            Spacer(modifier = Modifier.padding(32.dp))
            Text1(
                text = "Water is life. Water is a basic human need. In various lines of life, humans need water.",
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Input1("New Password", "", onValueChange = { password = it }, false)
            Spacer(modifier = Modifier.padding(16.dp))
            Input1("Confirm Password", "", onValueChange = { confirmPassword = it }, false)

            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.padding(bottom = 32.dp)) {
                Text1(text = "Have an account? ")
                Text1Clickable(text = "Login") {

                }
            }
            Button1(
                onClick = { navController.navigate(Screens.Login.screen) },
                text = "Reset Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
        }
    }
}
