package ar.edu.ort.tp3_ort_2025_parcial.model.cart

data class CartItem (
    val id: Int,
    val title: String,
    val price: Double,
    val quantity: Int,
    val total: Double,
    val discountPercentage: Double,
    val discountedTotal: Double,
    val thumbnail: String,
)