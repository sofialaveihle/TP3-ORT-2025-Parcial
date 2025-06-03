package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.CartItemRetrofit
import ar.edu.ort.tp3_ort_2025_parcial.model.cart.Cart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCartItemService @Inject constructor (
    private val cartItemRetrofit: CartItemRetrofit
) {
    suspend fun invoke(): Cart? = withContext(context = Dispatchers.IO) {
        cartItemRetrofit.getCart()
    }
}