package ar.edu.ort.tp3_ort_2025_parcial.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Black

@Preview
@Composable
fun Title2Preview(){
    Title2(
        text = "Test",
        textAlign = TextAlign.Center
    )
}

@Composable
fun Title2(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign
){
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(color = Black),
        textAlign = textAlign,
        modifier = modifier
    )
}