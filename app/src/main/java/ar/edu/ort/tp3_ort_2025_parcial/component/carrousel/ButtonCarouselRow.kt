package ar.edu.ort.tp3_ort_2025_parcial.component.carrousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button2

@Composable
fun ButtonCarouselRow(
    modifier: Modifier = Modifier
) {
//    val items = getButtonCarouselItems()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val items = getButtonCarouselItems().mapIndexed { index, item ->
        item.copy(
            selected = index == selectedIndex,
            onClick = { selectedIndex = index }
        )
    }

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
//        items(items.size) { index ->
//            val item = items[index]
//            Button2(
//                onClick = item.onClick,
//                text = item.text,
//                isSelected = item.selected
//            )
//        }
        items(items.size) { index ->
            val item = items[index]
            Button2(
                onClick = item.onClick,
                text = item.text,
                isSelected = item.selected
            )
        }
    }
}

data class ButtonCarouselItem(
    val text: String,
    val onClick: () -> Unit,
    val selected: Boolean
)

fun getButtonCarouselItems(): List<ButtonCarouselItem> {
    return listOf(
        ButtonCarouselItem("Option 1", onClick = { println("Promo 1 click") }, selected = true),
        ButtonCarouselItem("Option 2", onClick = { println("Promo 2 click") }, selected = false),
        ButtonCarouselItem("Option 3", onClick = { println("Promo 3 click") }, selected = false),
        ButtonCarouselItem("Option 4", onClick = { println("Promo 4 click") }, selected = false),
        ButtonCarouselItem("Option 5", onClick = { println("Promo 5 click") }, selected = false)
    )
}
