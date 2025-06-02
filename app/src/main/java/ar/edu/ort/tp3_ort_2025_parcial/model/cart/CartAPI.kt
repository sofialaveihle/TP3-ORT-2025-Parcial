package ar.edu.ort.tp3_ort_2025_parcial.model.cart

import ar.edu.ort.tp3_ort_2025_parcial.model.cartItem.CartItem
import com.google.gson.annotations.SerializedName

data class CartAPI (
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "products") val products: List<CartItem>,
    @SerializedName(value = "total")val total: Double,
    @SerializedName(value = "discountedTotal")val discountedTotal: Double,
    @SerializedName(value = "userId")val userId: Int,
    @SerializedName(value = "totalProducts")val totalProducts: Int,
    @SerializedName(value = "totalQuantity")val totalQuantity: Int,
)