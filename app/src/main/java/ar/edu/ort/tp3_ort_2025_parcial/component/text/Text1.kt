package ar.edu.ort.tp3_ort_2025_parcial.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun Text1(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium
    )
}