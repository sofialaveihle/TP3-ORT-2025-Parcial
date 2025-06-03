package ar.edu.ort.tp3_ort_2025_parcial.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Black

@Composable
fun HomepageText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.displayMedium,
        color = Black,
        modifier = modifier,
    )
}