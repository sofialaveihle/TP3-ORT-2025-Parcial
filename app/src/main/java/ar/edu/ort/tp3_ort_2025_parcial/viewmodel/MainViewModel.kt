package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.lifecycle.ViewModel
import ar.edu.ort.tp3_ort_2025_parcial.model.user.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _user = MutableStateFlow<UserModel?>(null)
    val user: StateFlow<UserModel?> = _user

    fun setUser(user: UserModel) {
        _user.value = user
    }
}