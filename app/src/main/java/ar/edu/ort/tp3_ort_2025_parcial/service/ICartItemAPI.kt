package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.model.cart.CartItemResponse
import retrofit2.Response
import retrofit2.http.GET

interface ICartItemAPI {
    @GET("/carts/1")
    suspend fun getCart(): Response<CartItemResponse>
}