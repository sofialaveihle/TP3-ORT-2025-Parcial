package ar.edu.ort.tp3_ort_2025_parcial.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ar.edu.ort.tp3_ort_2025_parcial.model.room.CreditCardEntity

@Dao
interface CreditCardDAO {

    @Query("SELECT * FROM credit_cards WHERE userId = :userId LIMIT 1")
    suspend fun getCardByUserId(userId: String): CreditCardEntity?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: CreditCardEntity)

    @Update
    suspend fun updateCreditCard(card: CreditCardEntity)

}