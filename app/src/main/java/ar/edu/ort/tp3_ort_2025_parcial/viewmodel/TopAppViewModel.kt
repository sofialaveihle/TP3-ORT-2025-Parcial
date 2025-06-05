package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

class TopAppViewModel : ViewModel() {

    private val _title = mutableStateOf("")
    val title: State<String> = _title
    private val _showFavorite = mutableStateOf(false)

    val showFavorite: State<Boolean> = _showFavorite
    fun setTopBar(title: String) {
        _title.value = title
    }

    fun updateRoute(route: String?) {
        _showFavorite.value = route?.startsWith(Screens.ProductDetail.screen) == true
    }
}