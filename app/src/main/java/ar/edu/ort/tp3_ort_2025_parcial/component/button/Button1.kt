package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Preview
@Composable
fun Button1Preview() {
    Button1(
        onClick = {},
        text = "Test",
        modifier = Modifier
    )
}

@Composable
fun Button1(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(size = 30.5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple,
            contentColor = White
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.displayMedium
        )
    }
}