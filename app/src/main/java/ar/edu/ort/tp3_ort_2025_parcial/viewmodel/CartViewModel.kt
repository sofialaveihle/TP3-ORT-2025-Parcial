package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3_ort_2025_parcial.model.cart.Cart
import ar.edu.ort.tp3_ort_2025_parcial.service.GetCartItemService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemsService: GetCartItemService
) : ViewModel() {

    var cart by mutableStateOf<Cart?>(null)
        private set

    fun loadCart() {
        viewModelScope.launch {
            val cartResponse = getCartItemsService.invoke()
            if (cartResponse != null) {
                cart = cartResponse
            }
        }
    }
}