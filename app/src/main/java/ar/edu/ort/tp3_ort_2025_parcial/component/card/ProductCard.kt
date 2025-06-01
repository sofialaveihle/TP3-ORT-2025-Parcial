package ar.edu.ort.tp3_ort_2025_parcial.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import ar.edu.ort.tp3_ort_2025_parcial.model.Product
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Black
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3
import coil.compose.AsyncImage


@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        Modifier
            .width(150.dp)
            .height(210.dp)
            .background(
                color = Gray3,
                shape = RoundedCornerShape(size = 24.dp)
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProductImage(
                product = product,
                onClick = onClick
            )
//            Image(
//                painter = painterResource(id = R.drawable.product_1),
//                contentDescription = product.title,
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .width(142.dp)
//                    .height(142.dp)
//                    .clickable { onClick() }
//            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.bodySmall
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
//                      text = product.price.toString(),
                        text = "$${product.price}",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 30.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontWeight = FontWeight(600),
                            color = Black,
                            textAlign = TextAlign.Left,
                        ),
                    )
                    Box(
                        modifier = Modifier
                            .clickable { onClick() },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.plus_icon_button_elipse),
                            contentDescription = "Plus button",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { onClick() }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.plus_icon_button_plus),
                            contentDescription = "Plus button",
                            modifier = Modifier
                                .width(16.dp)
                                .height(16.dp)
                                .clickable { onClick() }
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun ProductImage(
    product: Product,
    onClick: () -> Unit
) {
    AsyncImage(
        model =  product.images.firstOrNull(),
        contentDescription = product.description,
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.placeholder),
        modifier = Modifier
            .width(142.dp)
            .height(142.dp)
            .clickable { onClick() }
    )
}
