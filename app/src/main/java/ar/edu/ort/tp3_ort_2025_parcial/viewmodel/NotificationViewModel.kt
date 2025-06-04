package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3_ort_2025_parcial.data.repository.NotificationsRepository
import ar.edu.ort.tp3_ort_2025_parcial.model.Notification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val repository: NotificationsRepository
) : ViewModel() {

    private val _userId = 1 // Simulado, si implementamos room en el login se puede obtener desde ahi

    init {
        viewModelScope.launch {
            val current = repository.getNotificationsByUserId(_userId).firstOrNull()
            if (current == null) {
                repository.insert(
                    Notification(
                        user_id = _userId,
                        likedPost = true,
                        newMessage = true,
                        itemSold = true
                    )
                )
            }
        }
    }

    val notificationSettings = repository.getNotificationsByUserId(_userId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun toggleNotification(type: String, enabled: Boolean) {
        viewModelScope.launch {
            val current = notificationSettings.value ?: return@launch
            val updated = when (type) {
                "Liked Post" -> current.copy(likedPost = enabled)
                "New Message" -> current.copy(newMessage = enabled)
                "Item Sold" -> current.copy(itemSold = enabled)
                else -> current
            }
            repository.update(updated)
        }
    }
}