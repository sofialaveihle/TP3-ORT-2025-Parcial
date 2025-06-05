package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3_ort_2025_parcial.model.user.UserModel
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: IServiceLogin) : ViewModel() {
    private val _user = MutableStateFlow<UserModel?>(null)
    val user: StateFlow<UserModel?> = _user

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val loginResp = authService.login(username, password)
                if (loginResp != null) {
                    fetchUser(loginResp.accessToken)
                } else {
                    _error.value = "Invalid "
                }
            } catch (e: Exception) {
                _error.value = "Error in the login: ${e.message}"
            }
        }
    }

    private suspend fun fetchUser(token: String) {
        try {
            val userModel = authService.me(token)
            if (userModel != null) {
                _user.value = userModel
            } else {
                _error.value = "Error, cant get the user"
            }
        } catch (e: Exception) {
            _error.value = "Error getting the user: ${e.message}"
        }
    }
}