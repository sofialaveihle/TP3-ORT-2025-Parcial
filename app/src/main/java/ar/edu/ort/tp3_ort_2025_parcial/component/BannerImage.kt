package ar.edu.ort.tp3_ort_2025_parcial.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R

@Composable
fun BannerImage(
    color: Color
) {
    Box(
        modifier = Modifier
            .width(330.dp)
            .height(160.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                color = color,
                shape = RoundedCornerShape(size = 24.dp)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_unsplash),
            contentDescription = "Unsplash effect image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f)
        )
    }
}
