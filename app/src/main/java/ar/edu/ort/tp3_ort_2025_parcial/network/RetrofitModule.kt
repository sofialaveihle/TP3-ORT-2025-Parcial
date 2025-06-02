package ar.edu.ort.tp3_ort_2025_parcial.network

import ar.edu.ort.tp3_ort_2025_parcial.core.Config
import ar.edu.ort.tp3_ort_2025_parcial.service.IProductAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        //Creo Retrofit
        return Retrofit.Builder()
            .baseUrl(Config.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideProductApiClient(retrofit: Retrofit): IProductAPI {
        return retrofit.create(IProductAPI::class.java)
    }

}