package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
fun OutlinedButtonPreview(){
    OutlinedButton(
        onClick = {},
        text = "Test"
    )
}

@Composable
fun OutlinedButton(
    onClick: () -> Unit,
    text: String
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(327.dp)
            .height(60.dp),
        shape = RoundedCornerShape(size = 30.5.dp),
        border = BorderStroke(2.dp, Purple),
        colors = ButtonDefaults.outlinedButtonColors(
        containerColor = White,
        contentColor = Purple)

    ){
        Text(
            text = text,
            style = MaterialTheme.typography.displayMedium.copy(color = Purple)
        )
    }
}