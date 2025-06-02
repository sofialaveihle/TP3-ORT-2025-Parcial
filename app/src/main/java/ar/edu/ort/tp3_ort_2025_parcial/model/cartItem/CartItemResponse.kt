package ar.edu.ort.tp3_ort_2025_parcial.model.cartItem

import com.google.gson.annotations.SerializedName

data class CartItemResponse (
    @SerializedName("products") val products: List<CartItemAPI>
)