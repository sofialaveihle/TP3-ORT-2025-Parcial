package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button4
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .clickable { navController.navigate(Screens.Location.screen) }
            ) {
                Text(
                    text = "Location",
                    color = Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = "Jebres, Surakarta",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button4(
                    image = painterResource(id = R.drawable.search_icon),
                    onClick = {}
                )
                Button4(
                    image = painterResource(id = R.drawable.notification_icon),
                    onClick = {}
                )
            }
        }

    }
}