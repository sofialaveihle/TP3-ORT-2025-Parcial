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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button2
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button3
import ar.edu.ort.tp3_ort_2025_parcial.component.grid.ProductGrid
import ar.edu.ort.tp3_ort_2025_parcial.component.image.BannerImage
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Black
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray4
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Orange
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun ProfileSeller(
    navController: NavController,
    viewModel: MainViewModel = viewModel()
) {
    val products = viewModel.products
    var selected by remember { mutableStateOf("Seller Mode") }
    var selectedTab by remember { mutableStateOf("Product") }

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
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
                    onClick = { navController.navigate(("profileUser")) },
                    text = "Profile",
                    isSelected = selected == "Profile",
                    modifier = Modifier.weight(1f)
                )
                Button3(
                    onClick = { selected = "Seller Mode" },
                    text = "Seller Mode",
                    isSelected = selected == "Seller Mode",
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Box(
            modifier = Modifier
                .width(400.dp)
                .height(160.dp)
                .padding(10.dp)
        ) {
            BannerImage(color = Orange)
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
                        painter = painterResource(id = R.drawable.profile_ellipse),
                        contentDescription = "Profile",
                        modifier = Modifier.padding(1.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.profile_p_letter),
                        contentDescription = "Profile",
                        modifier = Modifier.padding(1.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
                //.padding(vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.height(45.dp)
            )
            Title2(
                text = "Pittashop",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf(
                    "109" to "Followers",
                    "992" to "Following",
                    "80" to "Sales"
                ).forEach { (value, label) ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = value,
                            style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 28.8.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                                    fontWeight = FontWeight(700),
                                    color = Black
                            )
                        )
                        Text(
                            text = label,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 19.2.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Gray4
                            ))
                    }
                }
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf("Product", "Sold", "Stats").forEach { label ->
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
                navController = navController,
                productList = products
            )

        }
    }
}