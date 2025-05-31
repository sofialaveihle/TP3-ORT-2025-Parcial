package ar.edu.ort.tp3_ort_2025_parcial.component.text

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple

@Composable
fun TextLink(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 19.2.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontWeight = FontWeight(500),
            color = Purple,

            ),
        modifier = Modifier.clickable(onClick = onClick),
    )
}