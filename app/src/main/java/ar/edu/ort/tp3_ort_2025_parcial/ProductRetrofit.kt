package ar.edu.ort.tp3_ort_2025_parcial

import ar.edu.ort.tp3_ort_2025_parcial.model.Product
import ar.edu.ort.tp3_ort_2025_parcial.service.IProductAPI
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceProduct
import javax.inject.Inject

data class ProductRetrofit
@Inject
constructor(private val service: IProductAPI) : IServiceProduct {
    //Inyección de dependencia Retrofit y devolverá una interfaz
    //Response debe llamar a la funcion definida en INameAPI (interfaz que llama a la API)
    override suspend fun getProductsByCategoryGroceries(): List<Product>? {

        val response = service.getProductsByCategoryGroceries()

//        return if (response.isSuccessful) {
//            val result = response.body()?.products?.map {
//                Product(
//                    title = it.title,
//                    description = it.description,
//                    category = it.category,
//                    price = it.price,
//                    tags = it.tags
//                )
//            }
//            result
//        } else {
//            emptyList()
//        }
        return if (response.isSuccessful) {
            response.body()
                ?.products
                ?.filter { it.tags.contains("pet supplies") } // ← ahora sí funciona
                ?.map {
                    Product(
                        title = it.title,
                        description = it.description,
                        category = it.category,
                        price = it.price,
                        tags = it.tags // suponiendo que tu modelo final Product también lo tiene
                    )
                }
        } else {
            emptyList()
        }
    }
}
