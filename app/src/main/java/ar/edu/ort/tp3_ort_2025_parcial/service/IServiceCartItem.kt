package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.model.cart.Cart

interface IServiceCartItem {
    suspend fun getCart(): Cart?
}