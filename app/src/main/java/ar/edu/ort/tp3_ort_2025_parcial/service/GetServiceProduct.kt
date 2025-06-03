package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.network.ProductRetrofit
import ar.edu.ort.tp3_ort_2025_parcial.model.product.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetServiceProduct @Inject constructor(
    private val productRetrofit: ProductRetrofit
) {
    suspend fun invoke(): List<Product>? = withContext(context = Dispatchers.IO) {
        productRetrofit.getProductsByCategoryGroceries()
    }
}