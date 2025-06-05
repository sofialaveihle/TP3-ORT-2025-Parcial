package ar.edu.ort.tp3_ort_2025_parcial.component.text

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple


@Composable
fun Text1Clickable(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = Purple,
        modifier = modifier.clickable { onClick() },
    )
}