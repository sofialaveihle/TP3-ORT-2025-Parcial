package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Composable
fun Button4(
    image: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier.size(46.dp),
        shape = RoundedCornerShape(16.dp),
        color = White,
        shadowElevation = 8.dp
    ) {
        IconButton(onClick = onClick) {
            Image(
                painter = image,
                contentDescription = "image description",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun Button4Preview() {
    Button4(
        onClick = {},
        image = painterResource(id = R.drawable.search_icon),
    )
}
