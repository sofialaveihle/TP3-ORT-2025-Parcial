package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.image.BannerImage
import ar.edu.ort.tp3_ort_2025_parcial.component.button.ButtonIconEdit
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1WithTitle
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title2
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun ProfileUserEdit(
    navController: NavController,
    topBarViewModel: MainViewModel
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Account")
    }

    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(400.dp)
                .height(160.dp)
                .padding(10.dp)
        ) {
            Box{
                BannerImage(color = Gray3)
                ButtonIconEdit(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(14.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .offset(y = 50.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_user_photo),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .padding(1.dp)
                            .align(Alignment.Center)
                            .size(100.dp)
                    )
                    ButtonIconEdit(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
        ) {
            Spacer(
                modifier = Modifier.height(45.dp)
            )
            Title2(
                text = "Abduldul",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Input1WithTitle(
                text = "Name",
                value = name,
                onValueChange = {name = it},
                isPassword = false
            )
            Input1WithTitle(
                text = "Username",
                value = username,
                onValueChange = {username = it},
                isPassword = false
            )
            Input1WithTitle(
                text = "Email",
                value = email,
                onValueChange = {email = it},
                isPassword = false
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
            Button1(
                onClick = { navController.navigate(Screens.ProfileUser.screen) },
                text = "Save Changes",
                isSelected = true,
                modifier = Modifier
            )
        }
    }
}