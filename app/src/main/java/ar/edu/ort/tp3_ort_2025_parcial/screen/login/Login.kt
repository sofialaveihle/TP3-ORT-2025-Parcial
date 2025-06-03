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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.button.ButtonSocialMediaLogin
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1Clickable
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    Login(navController = navController)
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun Login(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                text = stringResource(R.string.login_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.04f))
            Text1(
                text = stringResource(R.string.under_title_text),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.04f))
            Input1(
                stringResource(R.string.email_place_holder),
                email,
                onValueChange = { email = it },
                true
            )
            Spacer(modifier = Modifier.padding(screenHeight * 0.02f))
            Input1(
                stringResource(R.string.password_place_holder),
                password,
                onValueChange = { password = it },
                true
            )
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
                    icon = painterResource(id = R.drawable.google_icon),
                    text = "Google",
                    screenHeight = screenHeight,
                    screenWidth = screenWidth,
                    modifier = Modifier
                )
                ButtonSocialMediaLogin(
                    onClick = {},
                    icon = painterResource(id = R.drawable.facebook_icon),
                    text = "Facebook",
                    screenHeight = screenHeight,
                    screenWidth = screenWidth,
                    modifier = Modifier.padding(start = screenWidth * 0.03f)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.padding(bottom = screenHeight * 0.04f)) {
                Text1(text = stringResource(R.string.do_not_have_an_account), textAlign = TextAlign.Center)
                Text1Clickable(text = stringResource(R.string.create_account)) {
                    navController.navigate(Screens.Register.screen)
                }
            }
            Button1(
                onClick = { },
                text = stringResource(R.string.get_started_button_text),
                isSelected = email.isNotEmpty() && password.isNotEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = screenHeight * 0.03f)
            )
        }
    }
}