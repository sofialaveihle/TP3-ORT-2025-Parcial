package ar.edu.ort.tp3_ort_2025_parcial.component.carrousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button2

@Composable
fun ButtonCarouselRow(
    modifier: Modifier = Modifier
) {
    val items = getButtonCarouselItems()

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items.size) { index ->
            val item = items[index]
            Button2(
                onClick = item.onClick,
                text = item.text,
                enabled = item.enabled
            )
        }
    }
}

data class ButtonCarouselItem(
    val text: String,
    val onClick: () -> Unit,
    val enabled: Boolean
)

fun getButtonCarouselItems(): List<ButtonCarouselItem> {
    return listOf(
        ButtonCarouselItem("Promo 1", onClick = { println("Promo 1 click") }, enabled = true),
        ButtonCarouselItem("Promo 2", onClick = { println("Promo 2 click") }, enabled = false),
        ButtonCarouselItem("Promo 3", onClick = { println("Promo 3 click") }, enabled = false),
        ButtonCarouselItem("Promo 4", onClick = { println("Promo 4 click") }, enabled = false),
        ButtonCarouselItem("Promo 5", onClick = { println("Promo 5 click") }, enabled = false)
    )
}
