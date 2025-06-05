package ar.edu.ort.tp3_ort_2025_parcial.model.cart

import ar.edu.ort.tp3_ort_2025_parcial.model.cartItem.CartItem

data class Cart (
    val id: Int,
    val products: List<CartItem>,
    val total: Double,
    val discountedTotal: Double,
    val userId: Int,
    val totalProducts: Int,
    val totalQuantity: Int,
)