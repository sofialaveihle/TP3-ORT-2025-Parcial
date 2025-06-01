package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1WithTitle
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun ChangePassword(
    navController: NavController,
    topBarViewModel: MainViewModel
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Change Password")
    }

    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 40.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Input1WithTitle(
                text = "New Password",
                value = password,
                onValueChange = { password = it },
                isPassword = false
            )
            Input1WithTitle(
                text = "Confirm Password",
                value = passwordConfirm,
                onValueChange = { passwordConfirm = it },
                isPassword = false
            )
        }
        Button1(
            onClick = { navController.navigate("profileUser") },
            text = "Change Password",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}