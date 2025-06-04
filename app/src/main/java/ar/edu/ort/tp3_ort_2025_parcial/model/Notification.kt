package ar.edu.ort.tp3_ort_2025_parcial.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "notification" )
data class Notification(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val user_id: Int,
    @ColumnInfo(name = "liked_post")
    val likedPost: Boolean,
    @ColumnInfo(name = "new_message")
    val newMessage: Boolean,
    @ColumnInfo(name = "item_sold")
    val itemSold: Boolean
)
