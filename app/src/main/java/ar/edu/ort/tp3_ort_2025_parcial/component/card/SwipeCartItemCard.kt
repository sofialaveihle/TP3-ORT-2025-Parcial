package ar.edu.ort.tp3_ort_2025_parcial.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Red
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White
import ar.edu.ort.tp3_ort_2025_parcial.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun SwipeCartItemCard(
    title: String,
    total: Double,
    quantity: Int,
    thumbnail: String,
    onDelete: () -> Unit
) {
    var offsetX by remember { mutableFloatStateOf(1f) }
    val maxOffset = -100f
    val minScale = 0.69f
    val scaleFactor = 1f + (offsetX / maxOffset) * (minScale - 1f)
    val scale = scaleFactor.coerceIn(minScale, 1f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(shape = RoundedCornerShape(16.dp))
                .background(White),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                painter = painterResource(id = R.drawable.delete_icon),
                contentDescription = "Delete",
                tint = Red,
                modifier = Modifier
                    .padding(end = 24.dp)
                    .size(24.dp)
                    .clickable { onDelete() }
            )
        }
        Box(
            modifier = Modifier
                .graphicsLayer {
                    translationX = offsetX
                    scaleX = scale
                    scaleY = scale
                }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            offsetX = if (offsetX < maxOffset / 2f) maxOffset else 0f
                        },
                        onHorizontalDrag = { _, dragAmount ->
                            offsetX = (offsetX + dragAmount).coerceIn(maxOffset, 0f)
                        }
                    )
                }
        ) {
            CartItemCard(
                title = title,
                total = total,
                quantity = quantity,
                thumbnail = thumbnail
            )
        }
    }
}