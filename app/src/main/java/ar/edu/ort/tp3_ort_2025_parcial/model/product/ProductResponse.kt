package ar.edu.ort.tp3_ort_2025_parcial.model.product

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("products") val products: List<ProductAPI>
)