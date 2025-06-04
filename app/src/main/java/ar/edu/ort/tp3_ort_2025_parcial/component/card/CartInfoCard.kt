package ar.edu.ort.tp3_ort_2025_parcial.component.card

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White
import ar.edu.ort.tp3_ort_2025_parcial.R

@SuppressLint("DefaultLocale")
@Composable
fun CartInfoCard(
    cantItems: Int?,
    total: Double?,
    discount: Double?
) {
    val finalTotal = (total ?: 0.0) - (discount ?: 0.0)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CartInfoCardText(
                text = "${cantItems ?: 0} " + stringResource(R.string.items),
            )
            CartInfoCardText(
                text = "$" + String.format("%.2f", total ?: 0.0),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CartInfoCardText(
                text = stringResource(R.string.discount),
            )
            CartInfoCardText(
                text = "- $" + String.format("%.2f", discount ?: 0.0),
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CartInfoCardText(
                text = stringResource(R.string.total),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                )
            )
            CartInfoCardText(
                text = "$" + String.format("%.2f", finalTotal),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                )
            )
        }
    }
}

@Composable
fun CartInfoCardText(
    text: String,
    style: TextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 19.2.sp,
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight(400),
        color = Gray,
        textAlign = TextAlign.Justify,
    )
){
    Text(
        text = text,
        style = style
    )
}