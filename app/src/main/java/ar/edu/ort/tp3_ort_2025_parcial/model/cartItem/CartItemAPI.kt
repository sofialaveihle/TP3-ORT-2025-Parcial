package ar.edu.ort.tp3_ort_2025_parcial.model.cartItem

import com.google.gson.annotations.SerializedName

data class CartItemAPI (
    @SerializedName(value = "id")val id: Int,
    @SerializedName(value="title") val title: String,
    @SerializedName(value="price") val price: Double,
    @SerializedName(value="quantity")val quantity: Int,
    @SerializedName(value="total")val total: Double,
    @SerializedName(value="discountPercentage")val discountPercentage: Double,
    @SerializedName(value="discountedTotal")val discountedTotal: Double,
    @SerializedName(value="thumbnail")val thumbnail: String,
)