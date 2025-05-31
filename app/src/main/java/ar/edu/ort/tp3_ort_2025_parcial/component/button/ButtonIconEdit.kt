package ar.edu.ort.tp3_ort_2025_parcial.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R

@Composable
fun ButtonIconEdit(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.TopEnd
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_edit_ellipse),
            contentDescription = "White ellipse for edit button",
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .clickable { onClick() }
        )
        Image(
            painter = painterResource(id = R.drawable.profile_edit_pen),
            contentDescription = "Pen for edit button",
            modifier = Modifier
                .width(12.dp)
                .height(12.dp)
                .clickable { onClick() }
        )
    }
}