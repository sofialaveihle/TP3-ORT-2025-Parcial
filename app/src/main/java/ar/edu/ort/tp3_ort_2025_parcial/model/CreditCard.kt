package ar.edu.ort.tp3_ort_2025_parcial.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "credit_card" )
data class CreditCard(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val user_id: Int,
    @ColumnInfo(name = "card_number")
    val cardNumber: String,
    @ColumnInfo(name = "card_name")
    val cardName: String,
    @ColumnInfo(name = "expiration_date")
    val expirationDate: String
    )

