package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3_ort_2025_parcial.model.product.Product
import ar.edu.ort.tp3_ort_2025_parcial.service.GetServiceProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsService: GetServiceProduct,
) : ViewModel() {
    var products by mutableStateOf<List<Product>>(emptyList())

    fun loadProducts() {
        viewModelScope.launch {
            val productList = getProductsService.invoke()
            if (!productList.isNullOrEmpty() && productList.isNotEmpty()) {
                products = productList
            }
        }
    }

    fun getProductById(id: Int?): Product? {
        return products.find { it.id == id }
    }
}