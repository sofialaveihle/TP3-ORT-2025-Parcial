package ar.edu.ort.tp3_ort_2025_parcial.component.card

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.model.product.Product
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Black
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple
import coil.compose.AsyncImage

@SuppressLint("DefaultLocale")
@Composable
fun CartItemCard(
    title: String,
    total: Double,
    quantity: Int,
    thumbnail: String
) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x12000000),
                ambientColor = Color(0x12000000)
            )
            .width(327.dp)
            .height(120.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
    ){
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model =  thumbnail,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .width(64.dp)
                    .height(84.dp)
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontWeight = FontWeight(600),
                        color = Black,

                        )
                )
                Text(
                    text = "Quantity: $quantity",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 19.2.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Gray,
                    ),
                    textAlign = TextAlign.Justify,
                )
                Text(
                    text = "$" + String.format("%.2f", total.toDouble()),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontWeight = FontWeight(600),
                        color = Purple,
                    )
                )
            }
        }
    }
}