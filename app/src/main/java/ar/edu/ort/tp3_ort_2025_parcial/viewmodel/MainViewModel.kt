package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import ar.edu.ort.tp3_ort_2025_parcial.navigation.getSectionForRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    // Homepage
    private val _isSheetOpen = mutableStateOf(false)
    val isSheetOpen: State<Boolean> = _isSheetOpen

    private val _selectedLocation = mutableStateOf("Jebres, Surakarta")
    val selectedLocation: State<String> = _selectedLocation

    private val _selectedSection = mutableStateOf("Activity")
    val selectedSection: State<String> = _selectedSection

    fun setSelectedSection(section: String) {
        _selectedSection.value = section
    }

    // Top App Bar
    private val _title = mutableStateOf("")
    val title: State<String> = _title

    fun openSheet() {
        _isSheetOpen.value = true
    }
    fun setTopBar(title: String) {
        _title.value = title
    }

    fun closeSheet() {
        _isSheetOpen.value = false
    }
    // Bottom App Bar
    private val _currentSection = mutableStateOf<String?>(null)
    val currentSection: State<String?> = _currentSection

    fun updateLocation(newLocation: String) {
        _selectedLocation.value = newLocation
        closeSheet()
    }
    fun updateSectionFromRoute(route: String?) {
        _currentSection.value = getSectionForRoute(route)
    }

    // Search Bar
    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText

    fun updateSearchText(newText: String) {
        _searchText.value = newText
    }

    // Notification -> Estados de switches
    // como la logica no es complicada uso el mismo view model, se puede hacer un achivo separado
    var notificationSettings = mutableStateMapOf(
        "Liked Post" to true,
        "New Message" to true,
        "Item Sold" to true
    )
        private set

    fun toggleNotification(key: String, value: Boolean) {
        notificationSettings[key] = value
    }

}