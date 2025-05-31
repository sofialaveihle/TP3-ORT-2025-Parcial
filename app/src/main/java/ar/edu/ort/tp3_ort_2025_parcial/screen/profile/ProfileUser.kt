package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
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
import ar.edu.ort.tp3_ort_2025_parcial.component.BannerImage
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button2
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button3
import ar.edu.ort.tp3_ort_2025_parcial.component.grid.ProductGrid
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3

@Composable
fun ProfileUser(
    navController: NavController
) {
    var selected by remember { mutableStateOf("Profile") }
    var selectedTab by remember { mutableStateOf("EditProfile") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(280.dp)
                .height(45.dp)
                .background(
                    color = Gray3,
                    shape = RoundedCornerShape(40.dp)
                )
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Button3(
                    onClick = { selected = "Profile"},
                    text = "Profile",
                    isSelected = selected == "Profile"
                )
                Button3(
                    onClick = { navController.navigate(("profileSeller"))},
                    text = "Seller Mode",
                    isSelected = selected == "Seller Mode"
                )
            }
        }
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(160.dp)
                .padding(10.dp)
        ) {
            BannerImage(color = Gray3)
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
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title2(
                text = "Abduldul",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
            ) {
                listOf("Saved", "Edit Profile").forEach { label ->
                    Button2(
                        onClick = { selectedTab = label },
                        text = label,
                        isSelected = selectedTab == label
                    )
                }
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            ProductGrid(
                navController
            )
        }
    }
}