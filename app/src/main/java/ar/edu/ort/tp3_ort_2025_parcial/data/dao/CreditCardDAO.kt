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
    @Query("SELECT card_number FROM credit_card WHERE user_id = :userId")
    fun findCreditCardNumberByUserId(userId: Int): Flow<String>
    @Query("SELECT card_name FROM credit_card WHERE user_id = :userId")
    fun findCreditCardNameByUserId(userId: Int): Flow<String>
    @Query("SELECT expiration_date FROM credit_card WHERE user_id = :userId")
    fun findCreditCardExpirationByUserId(userId: Int): Flow<String>
    @Insert
    suspend fun insert(creditCard: CreditCard)
    @Update
    suspend fun update(creditCard: CreditCard)

}