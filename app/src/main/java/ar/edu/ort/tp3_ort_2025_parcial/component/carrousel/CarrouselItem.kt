package ar.edu.ort.tp3_ort_2025_parcial.component.carrousel

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ar.edu.ort.tp3_ort_2025_parcial.R

data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
    val text: String,
    val contentDescription: String
)

@Composable
fun getCarouselItems(): List<CarouselItem> {
    return listOf(
        CarouselItem(
            0,
            R.drawable.carrousel_image_one,
            stringResource(R.string.welcome_carrousel_text_one),
            stringResource(R.string.welcome_carrousel_text_one_contentDescription)
        ),
        CarouselItem(
            1,
            R.drawable.carrousel_image_two,
            stringResource(R.string.welcome_carrousel_text_two),
            stringResource(R.string.welcome_carrousel_text_two_contentDescription)
        ),
        CarouselItem(
            2,
            R.drawable.carrousel_image_three,
            stringResource(R.string.welcome_carrousel_text_three),
            stringResource(R.string.welcome_carrousel_text_three_contentDescription)
        )
    )
}