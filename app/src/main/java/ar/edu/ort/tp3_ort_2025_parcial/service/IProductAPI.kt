package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface IProductAPI {
    @GET("/products/category/groceries")
    suspend fun getProductsByCategoryGroceries(): Response<ProductResponse>
}