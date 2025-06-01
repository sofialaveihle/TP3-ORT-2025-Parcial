package ar.edu.ort.tp3_ort_2025_parcial.component.checkbox


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray4
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    Column {
        Checkbox(false, {}, modifier = Modifier)
        Checkbox(true, {}, modifier = Modifier)
    }
}

@Composable
fun Checkbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .size(14.dp)
            .border(
                if (checked) 2.dp else 0.dp,
                if (checked) Purple else Gray4,
                RoundedCornerShape(2.86.dp)
            )
            .clickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .size(6.dp)
                .border(
                    if (checked) 4.dp else 0.dp,
                    if (checked) Purple else Color.Transparent,
                    RoundedCornerShape(1.71.dp)
                )
        )
    }
}
