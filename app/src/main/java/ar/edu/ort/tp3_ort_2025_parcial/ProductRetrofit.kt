package ar.edu.ort.tp3_ort_2025_parcial

import ar.edu.ort.tp3_ort_2025_parcial.model.Product
import ar.edu.ort.tp3_ort_2025_parcial.service.IProductAPI
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceProduct
import javax.inject.Inject

data class ProductRetrofit
@Inject
constructor(private val service: IProductAPI) : IServiceProduct {
    override suspend fun getProductsByCategoryGroceries(): List<Product>? {

        val response = service.getProductsByCategoryGroceries()

        return if (response.isSuccessful) {
            response.body()
                ?.products
                ?.filter { it.tags.contains("pet supplies") }
                ?.map {
                    Product(
                        id = it.id,
                        title = it.title,
                        description = it.description,
                        category = it.category,
                        price = it.price,
                        tags = it.tags,
                        images = it.images
                    )
                }
        } else {
            emptyList()
        }
    }
}
