package ar.edu.ort.tp3_ort_2025_parcial.di

import ar.edu.ort.tp3_ort_2025_parcial.network.LoginRetrofit
import ar.edu.ort.tp3_ort_2025_parcial.service.IServiceLogin
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract fun bindIServiceLogin(
        loginRetrofit: LoginRetrofit
    ): IServiceLogin
}