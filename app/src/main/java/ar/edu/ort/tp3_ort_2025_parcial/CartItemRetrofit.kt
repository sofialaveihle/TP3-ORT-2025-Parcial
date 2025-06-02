package ar.edu.ort.tp3_ort_2025_parcial

import ar.edu.ort.tp3_ort_2025_parcial.model.cart.CartItem
import ar.edu.ort.tp3_ort_2025_parcial.service.ICartItemAPI
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceCartItem
import javax.inject.Inject

data class CartItemRetrofit
@Inject
constructor(private val service: ICartItemAPI) : IServiceCartItem {
    override suspend fun getCart(): List<CartItem>? {
        val response = service.getCart()

        return if (response.isSuccessful) {
            response.body()
                ?.products
                ?.map {
                    CartItem(
                        id = it.id,
                        title = it.title,
                        price = it.price,
                        quantity = it.quantity,
                        total = it.total,
                        discountPercentage = it.discountPercentage,
                        discountedTotal = it.discountedTotal,
                        thumbnail = it.thumbnail,
                    )
                }
        } else {
            emptyList()
        }
    }
}