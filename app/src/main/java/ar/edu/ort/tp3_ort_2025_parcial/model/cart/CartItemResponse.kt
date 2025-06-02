package ar.edu.ort.tp3_ort_2025_parcial.model.cart

import com.google.gson.annotations.SerializedName

data class CartItemResponse (
    @SerializedName("products") val products: List<CartItemAPI>
)