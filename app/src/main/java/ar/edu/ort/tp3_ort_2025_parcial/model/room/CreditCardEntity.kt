package ar.edu.ort.tp3_ort_2025_parcial.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credit_cards")
data class CreditCardEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String,
    val cardNumber: String,
    val cardHolderName: String,
    val expirationDate: String
)