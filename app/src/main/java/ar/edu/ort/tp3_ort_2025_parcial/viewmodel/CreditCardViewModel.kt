package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3_ort_2025_parcial.data.repository.CreditCardRepository
import ar.edu.ort.tp3_ort_2025_parcial.model.CreditCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreditCardViewModel @Inject constructor(
    private val repository: CreditCardRepository
) : ViewModel() {

    private val userId = 1 // Simulado, reemplazar cuando tengas sesión de usuario

    init {
        viewModelScope.launch {
            val current = repository.getCreditCardByUserId(userId).firstOrNull()
            if (current == null) {
                repository.insertCreditCard(
                    CreditCard(
                        user_id = userId,
                        cardNumber = "",
                        cardName = "",
                        expirationDate = ""
                    )
                )
            }
        }
    }

    val creditCard: StateFlow<CreditCard?> =
        repository.getCreditCardByUserId(userId)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun saveCreditCard(card: CreditCard) {
        viewModelScope.launch {
            repository.insertCreditCard(card)
        }
    }

    fun updateField(field: String, value: String) {
        viewModelScope.launch {
            val current = creditCard.value ?: return@launch
            val updated = when (field) {
                "cardNumber" -> current.copy(cardNumber = value)
                "cardName" -> current.copy(cardName = value)
                "expirationDate" -> current.copy(expirationDate = value)
                else -> current
            }
            repository.updateCreditCard(updated)
        }
    }

    fun updateCreditCard(card: CreditCard) {
        viewModelScope.launch {
            repository.updateCreditCard(card)
        }
    }
}