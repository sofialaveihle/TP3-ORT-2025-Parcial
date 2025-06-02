package ar.edu.ort.tp3_ort_2025_parcial.model

import com.google.gson.annotations.SerializedName

data class ProductAPI (
    @SerializedName(value="id") val id: Int,
    @SerializedName(value="title") val title: String,
    @SerializedName(value="description") val description: String,
    @SerializedName(value="category") val category: String,
    @SerializedName(value="price") val price: Double,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("images") val images: List<String>
)
