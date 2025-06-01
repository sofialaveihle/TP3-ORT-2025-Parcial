package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.model.ProductAPI
import ar.edu.ort.tp3_ort_2025_parcial.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface IProductAPI {
    //Llamadas a API
    //Ejemplo
    /*
    @GET(value = "/v1/quotes")
    suspend fun getQuotes(): Response<List<QuoteApi>>
     */

//    @GET(value = "/products/category/groceries")
//    suspend fun getProductsByCategoryGroceries(): Response<List<ProductAPI>>

    @GET("/products/category/groceries")
    suspend fun getProductsByCategoryGroceries(): Response<ProductResponse>
}