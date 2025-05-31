package ar.edu.ort.tp3_ort_2025_parcial.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun Text1Preview() {
    Text1(
        text = "Test",
        textAlign = TextAlign.Center
    )
}

@Composable
fun Text1(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = modifier,
        textAlign = textAlign
    )
}