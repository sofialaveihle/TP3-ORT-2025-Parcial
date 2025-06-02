package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.ProductRetrofit
import ar.edu.ort.tp3_ort_2025_parcial.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetServiceProduct @Inject constructor(
    private val productRetrofit: ProductRetrofit
) {
    suspend fun invoke(): List<Product>? = withContext(context = Dispatchers.IO) {
        productRetrofit.getProductsByCategoryGroceries()
    }
    //De nuevo, función asincrónica, que devuelve una lista de frases
    //suspend fun invoke(): List<Quote>? = withContext(context = Dispatchers.IO) {
    // quoteRetrofit.getQuotes() //Llama internamente quoteRetrofit (que le llegó por inyección de dep.)
    //}

}