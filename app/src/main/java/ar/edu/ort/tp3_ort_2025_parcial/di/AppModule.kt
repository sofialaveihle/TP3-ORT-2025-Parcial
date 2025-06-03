package ar.edu.ort.tp3_ort_2025_parcial.di

import android.content.Context
import androidx.room.Room
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.dao.CreditCardDAO
import ar.edu.ort.tp3_ort_2025_parcial.dao.UserDAO
import ar.edu.ort.tp3_ort_2025_parcial.model.room.AppDatabase
import ar.edu.ort.tp3_ort_2025_parcial.repository.CreditCardRepository
import ar.edu.ort.tp3_ort_2025_parcial.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAppDB(
        @ApplicationContext
        context: Context
    )   = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        context.resources.getString(R.string.db_name) //"app_database"
    ).build()

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDAO {
        return appDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideCreditCardDao(appDatabase: AppDatabase): CreditCardDAO {
        return appDatabase.creditCardDao()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDAO: UserDAO): UserRepository {
        return UserRepository(userDAO)
    }

    @Provides
    @Singleton
    fun provideCreditCardRepository(creditCardDAO: CreditCardDAO): CreditCardRepository {
        return CreditCardRepository(creditCardDAO)
    }

}
