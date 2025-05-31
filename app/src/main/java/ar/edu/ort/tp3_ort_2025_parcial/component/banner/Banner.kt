package ar.edu.ort.tp3_ort_2025_parcial.component.banner

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R

@Preview
@Composable
fun BannerPreview(){
    PromoBanner(
        backgroundResId = R.drawable.banner_background, // tu imagen de fondo
        productResId = R.drawable.banner_image     // tu imagen del producto
    )
}

@Composable
fun PromoBanner(
    modifier: Modifier = Modifier,
    backgroundResId: Int,
    productResId: Int
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = backgroundResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = productResId),
                contentDescription = "Royal Canin Pomeranian",
                modifier = Modifier
                    .height(150.dp)
                    .aspectRatio(3f / 4f)
            )

            Spacer(modifier = Modifier.width(32.dp))

            Column {
                Text(
                    text = "Royal Canin\nAdult Pomeraniann",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Get an interesting promo\nhere, without conditions",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 15.6.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Justify,
                    )
                )
            }
        }
    }
}