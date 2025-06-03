package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Composable
fun Button5(
    favorite: Boolean,
    onToggle: () -> Unit
) {
    val icon = if (favorite) R.drawable.heart_filled_icon else R.drawable.heart_icon

    Surface(
        modifier = Modifier.size(46.dp),
        shape = RoundedCornerShape(16.dp),
        color = White,
        shadowElevation = 8.dp
    ) {
        IconButton(onClick = onToggle) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Favorito",
                modifier = Modifier.size(24.dp),
            )
        }
    }
}