package ar.edu.ort.tp3_ort_2025_parcial.component.numberPicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Black
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3

@Composable
fun NumberPicker(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(
                Gray3,
                RoundedCornerShape(50)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { onValueChange(value - 1) },
            modifier = Modifier
                .size(32.dp)
                .background(Gray3, shape = RoundedCornerShape(50))
        ) {
            Text(
                text = "–",
                style = MaterialTheme.typography.bodyLarge,
                color = Black
            )
        }

        Text(
            text = "$value",
            modifier = Modifier
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Black
        )

        IconButton(
            onClick = { onValueChange(value + 1) },
            modifier = Modifier
                .size(32.dp)
                .background(Gray3, shape = RoundedCornerShape(50))
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.bodyLarge,
                color = Black
            )
        }
    }
}