package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.ButtonIconEdit
import ar.edu.ort.tp3_ort_2025_parcial.component.button.MyButton
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.Input1
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray

@Composable
fun ProfileUserEdit(
    navController: NavController
) {
    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Falta TopBar
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(160.dp)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(330.dp)
                    .height(160.dp)
                    .background(
                        color = Gray,
                        shape = RoundedCornerShape(size = 24.dp)
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_unsplash),
                    contentDescription = "Unsplash effect image",
                    modifier = Modifier
                        .width(350.dp)
                        .height(365.dp)
                        .alpha(0.4f)
                )
                ButtonIconEdit(
                    onClick = { /*TODO*/ },
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
                .padding(vertical = 50.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
        ) {
            Title1(
                text = "Abduldul",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Name",
                textAlign = TextAlign.Left
            )
            Input1(
                placeHolder = "Name",
                value = name,
                onValueChange = {name = it},
                isPassword = false
            )
            Text(
                text = "Username",
                textAlign = TextAlign.Left
            )
            Input1(
                placeHolder = "Username",
                value = username,
                onValueChange = {username = it},
                isPassword = false
            )
            Text(
                text = "Email",
                textAlign = TextAlign.Left
            )
            Input1(
                placeHolder = "Email",
                value = email,
                onValueChange = {email = it},
                isPassword = false
            )
            MyButton(
                onClick = { /*TODO*/ },
                text = "Save Changes"
            )
        }
    }
}