package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple

@Preview
@Composable
fun ButtonPreview(){
    MyButton(
        onClick = {},
        text = "Test"
    )
}

@Composable
fun MyButton(
    onClick: () -> Unit,
    text: String
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = Purple,
                shape = RoundedCornerShape(size = 30.5.dp)
            )
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.displayMedium
        )
    }
}