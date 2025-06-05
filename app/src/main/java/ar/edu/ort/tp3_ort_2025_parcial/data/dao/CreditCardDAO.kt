package ar.edu.ort.tp3_ort_2025_parcial.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ar.edu.ort.tp3_ort_2025_parcial.model.CreditCard
import kotlinx.coroutines.flow.Flow

@Dao
interface CreditCardDAO {

    @Query("SELECT * FROM credit_card WHERE user_id = :userId")
    fun getCreditCardByUserId(userId: Int): Flow<CreditCard?>
    @Insert
    suspend fun insert(creditCard: CreditCard)
    @Update
    suspend fun update(creditCard: CreditCard)

}