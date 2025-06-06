package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Preview
@Composable
fun Button2Preview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button2(
            onClick = {},
            text = "Activo",
            isSelected = true
        )
        Button2(
            onClick = {},
            text = "Inactivo",
            isSelected = false
        )
    }
}

@Composable
fun Button2(
    onClick: () -> Unit,
    text: String,
    isSelected: Boolean
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(100.dp)
            .height(47.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Purple else Gray3,
            contentColor = if (isSelected) White else Gray2
        ),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.2.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontWeight = FontWeight(500),
                letterSpacing = 0.5.sp,
                color = LocalContentColor.current
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
