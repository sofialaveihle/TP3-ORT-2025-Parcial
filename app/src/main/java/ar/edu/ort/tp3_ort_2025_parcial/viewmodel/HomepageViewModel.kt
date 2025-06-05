package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomepageViewModel : ViewModel() {

    private val _isSheetOpen = mutableStateOf(false)
    val isSheetOpen: State<Boolean> = _isSheetOpen

    private val _selectedLocation = mutableStateOf("Jebres, Surakarta")
    val selectedLocation: State<String> = _selectedLocation

    private val _selectedSection = mutableStateOf("Activity")
    val selectedSection: State<String> = _selectedSection

    fun setSelectedSection(section: String) {
        _selectedSection.value = section
    }

    fun openSheet() {
        _isSheetOpen.value = true
    }

    fun closeSheet() {
        _isSheetOpen.value = false
    }

    fun updateLocation(newLocation: String) {
        _selectedLocation.value = newLocation
        closeSheet()
    }
}