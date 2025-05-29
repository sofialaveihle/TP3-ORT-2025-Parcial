package ar.edu.ort.tp3_ort_2025_parcial.network

import ar.edu.ort.tp3_ort_2025_parcial.core.Config
import ar.edu.ort.tp3_ort_2025_parcial.core.MyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor).addInterceptor(MyInterceptor)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        //Creo Retrofit
        return Retrofit.Builder()
            //Defino Url base
            .baseUrl(Config.baseUrl)
            .client(client)
            //Defino canal de comunicación (Gson)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Modificar segun enunciado
    /*@Singleton
    @Provides
    //Se crea QuotesApi y ya existe en todo el proyecto
    fun provideQuoteApiClient(retrofit: Retrofit): QuotesApi {
        return retrofit.create(QuotesApi::class.java)
    }*/

}