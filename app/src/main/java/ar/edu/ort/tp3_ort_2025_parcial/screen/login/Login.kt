package ar.edu.ort.tp3_ort_2025_parcial.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.button.ButtonSocialMediaLogin
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1
import ar.edu.ort.tp3_ort_2025_parcial.component.other.ErrorInfo
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1Clickable
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.LoginViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun Login(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
    loginViewModel: LoginViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val user by loginViewModel.user.collectAsState()
    val error by loginViewModel.error.collectAsState()

    LaunchedEffect(user) {
        user?.let {
            mainViewModel.setUser(user!!)
            navController.navigate(Screens.Home.screen)
        }
    }

    LaunchedEffect(error) {
        error?.let {
            password = ""
        }
    }

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
                .padding(top = 40.dp)
                .verticalScroll(scrollState)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title1(
                text = stringResource(R.string.login_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.02f))
            Text1(
                text = stringResource(R.string.under_title_text),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.02f))
            Input1(
                stringResource(R.string.email_place_holder),
                email,
                onValueChange = { email = it },
                false
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.02f))
            Input1(
                stringResource(R.string.password_place_holder),
                password,
                onValueChange = { password = it },
                true,
                isError = error != null
            )
            if (error != null) {
                ErrorInfo(
                    modifier = Modifier.align(alignment = Alignment.Start),
                    error = error ?: "error"
                )
                Text1Clickable(text = stringResource(R.string.forgot_password)) {
                    navController.navigate(Screens.ForgotPassword.screen)
                }
            }
            Spacer(modifier = Modifier.padding(screenHeight * 0.03f))

            Row {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = Gray
                )
                Spacer(modifier = Modifier.width(screenWidth * 0.02f))
                Text1(stringResource(R.string.or_divider_text), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.width(screenWidth * 0.02f))
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = Gray
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(screenHeight * 0.04f),
                horizontalArrangement = Arrangement.spacedBy(screenWidth * 0.03f)
            ) {
                ButtonSocialMediaLogin(
                    onClick = {},
                    icon1 = painterResource(id = R.drawable.google_icon),
                    icon2 = painterResource(id = R.drawable.google_icon_text),
                    contentDescription1 = "Google icon",
                    contentDescription2 = "Google text",
                    screenHeight = screenHeight,
                    screenWidth = screenWidth,
                    modifier = Modifier.weight(1f)
                )
                ButtonSocialMediaLogin(
                    onClick = {},
                    icon1 = painterResource(id = R.drawable.facebook_icon),
                    icon2 = painterResource(id = R.drawable.facebook_icon_text),
                    contentDescription1 = "Facebook icon",
                    contentDescription2 = "Facebook text",
                    screenHeight = screenHeight,
                    screenWidth = screenWidth,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.padding(bottom = screenHeight * 0.04f)) {
                Text1(
                    text = stringResource(R.string.do_not_have_an_account),
                    textAlign = TextAlign.Center
                )
                Text1Clickable(text = stringResource(R.string.create_account)) {
                    navController.navigate(Screens.Register.screen)
                }
            }
            Button1(
                onClick = { loginViewModel.login(email, password) },
                text = stringResource(R.string.get_started_button_text),
                isSelected = email.isNotEmpty() && password.isNotEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = screenHeight * 0.03f)
            )
        }
    }
}