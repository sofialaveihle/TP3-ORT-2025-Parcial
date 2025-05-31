package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val getQuotesUseCase: GetServiceQuotes
) : ViewModel() {

    //Definir atributos que manejan cambios de estados
    //Ejemplo: var Quote = mutableStateOf(value = "")

    //Crear funciones que manejen los cambios de estados

    //ViewModel --> GetServiceName --> NameRetrofit


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