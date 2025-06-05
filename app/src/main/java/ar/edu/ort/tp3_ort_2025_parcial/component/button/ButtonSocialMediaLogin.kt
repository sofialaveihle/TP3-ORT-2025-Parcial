package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray5
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Preview(showBackground = true)
@Composable
fun ButtonSocialMediaLoginPreview() {
    ButtonSocialMediaLogin(
        onClick = {},
        icon1 = painterResource(id = R.drawable.google_icon),
        icon2 = painterResource(id = R.drawable.google_icon_text),
        contentDescription1 = "Google",
        contentDescription2 = "Google",
        812.dp,
        375.dp,
        modifier = Modifier
    )
}

@Composable
fun ButtonSocialMediaLogin(
    onClick: () -> Unit,
    icon1: Painter,
    icon2: Painter,
    contentDescription1: String,
    contentDescription2: String,
    screenHeight: Dp,
    screenWidth: Dp,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(screenHeight * 0.08f)
            .border(1.dp, Gray5, RoundedCornerShape(size = 16.dp)),
        shape = RoundedCornerShape(size = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = icon1,
                contentDescription = contentDescription1,
                modifier = Modifier.size(screenHeight * 0.03f)
            )
            Spacer(modifier = Modifier.width(screenWidth * 0.02f))
            Image(
                painter = icon2,
                contentDescription = contentDescription2,
                modifier = Modifier.size(screenHeight * 0.08f)
            )
        }
    }
}