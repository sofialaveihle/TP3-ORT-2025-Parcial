package ar.edu.ort.tp3_ort_2025_parcial

import ar.edu.ort.tp3_ort_2025_parcial.service.INameAPI
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceName
import javax.inject.Inject

data class NameRetrofit
@Inject
constructor(private val service: INameAPI) : IServiceName {
//Inyección de dependencia Retrofit y devolverá una interfaz

    //Response debe llamar a la funcion definida en INameAPI (interfaz que llama a la API)

    /*override suspend fun getQuotes(): List<Quote>? {

        val response = service.getQuotes()

        return if (response.isSuccessful) {
            val result = response.body()?.map {
                Quote(
                    quote = it.quote,
                    author = it.author,
                    category = it.category
                )
            }
            result
        } else {
            emptyList()
        }
    }*/
}