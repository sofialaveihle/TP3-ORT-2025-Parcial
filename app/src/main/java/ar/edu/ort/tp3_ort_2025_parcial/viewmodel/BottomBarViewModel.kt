package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ar.edu.ort.tp3_ort_2025_parcial.navigation.getSectionForRoute

class BottomBarViewModel : ViewModel() {
    private val _currentSection = mutableStateOf<String?>(null)
    val currentSection: State<String?> = _currentSection

    fun updateSectionFromRoute(route: String?) {
        _currentSection.value = getSectionForRoute(route)
    }
}