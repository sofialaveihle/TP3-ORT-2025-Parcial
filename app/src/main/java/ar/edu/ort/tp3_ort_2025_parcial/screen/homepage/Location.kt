package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Composable
fun LocationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp)
    ) {
        // Indicador superior
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(width = 40.dp, height = 4.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(2.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Location", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Search bar simulada
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            border = BorderStroke(1.dp, Color.LightGray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Search your Location", color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Opción de autolocalización
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Track your Location", fontWeight = FontWeight.Bold)
                Text(
                    "automatically selects your\ncurrent location",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}