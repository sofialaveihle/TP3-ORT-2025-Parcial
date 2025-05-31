package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val getQuotesUseCase: GetServiceQuotes
) : ViewModel() {

    // Homepage
    private val _isSheetOpen = mutableStateOf(false)
    val isSheetOpen: State<Boolean> = _isSheetOpen

    private val _selectedLocation = mutableStateOf("Jebres, Surakarta")
    val selectedLocation: State<String> = _selectedLocation

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

    // Search Bar
    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText

    fun updateSearchText(newText: String) {
        _searchText.value = newText
    }
}