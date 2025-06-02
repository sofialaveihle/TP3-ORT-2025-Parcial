package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.numberPicker.NumberPicker
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Black
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import coil.compose.AsyncImage

@SuppressLint("DefaultLocale")
@Composable
fun ProductDetail(
    productId: Int?,
    viewModel: MainViewModel
){
    val product = viewModel.getProductById(productId)
    var quantity by remember { mutableIntStateOf(1) }
    val title = stringResource(R.string.product_detail)
    LaunchedEffect(Unit) {
        viewModel.setTopBar(title)
    }

    if (product == null) {
        Text(stringResource(R.string.product_not_found))
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.images[0],
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(24.dp)),
                contentScale = ContentScale.Fit
            )

            Text(
                text = product.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 17.6.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontWeight = FontWeight(600),
                    color = Black,
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
            )

            Text(
                text = product.description,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 19.2.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = Gray,
                    textAlign = TextAlign.Justify,
                ),
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NumberPicker(
                    value = quantity,
                    onValueChange = { quantity = it },
                    modifier = Modifier
                        .width(150.dp)
                )

                Text(
                    text = "$${String.format("%.2f", product.price)}",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 36.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontWeight = FontWeight(600),
                        color = Black,
                    ),
                    fontWeight = FontWeight.Bold
                )
            }

            Button1(
                onClick = { },
                text = stringResource(R.string.add_to_cart),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}