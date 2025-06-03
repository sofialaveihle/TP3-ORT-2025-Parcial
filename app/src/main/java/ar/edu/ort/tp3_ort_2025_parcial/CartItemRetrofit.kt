package ar.edu.ort.tp3_ort_2025_parcial

import ar.edu.ort.tp3_ort_2025_parcial.model.cart.Cart
import ar.edu.ort.tp3_ort_2025_parcial.service.ICartItemAPI
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceCartItem
import javax.inject.Inject

class CartItemRetrofit @Inject constructor(
    private val service: ICartItemAPI
) : IServiceCartItem {

    override suspend fun getCart(): Cart? {
        val response = service.getCart()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}