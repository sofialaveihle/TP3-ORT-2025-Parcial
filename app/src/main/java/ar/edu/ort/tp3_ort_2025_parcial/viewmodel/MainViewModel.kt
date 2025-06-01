package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import ar.edu.ort.tp3_ort_2025_parcial.navigation.getSectionForRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    // Top App Bar
    private val _title = mutableStateOf("")
    val title: State<String> = _title

    fun setTopBar(title: String) {
        _title.value = title
    }

    // Bottom App Bar
    private val _currentSection = mutableStateOf<String?>(null)
    val currentSection: State<String?> = _currentSection

    fun updateSectionFromRoute(route: String?) {
        _currentSection.value = getSectionForRoute(route)
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