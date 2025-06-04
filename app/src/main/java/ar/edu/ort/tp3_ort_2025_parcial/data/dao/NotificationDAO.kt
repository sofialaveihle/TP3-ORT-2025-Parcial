package ar.edu.ort.tp3_ort_2025_parcial.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ar.edu.ort.tp3_ort_2025_parcial.model.Notification
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationDAO {
    @Query("SELECT * FROM notification")
    fun getAllNotifications(): Flow<List<Notification>>

    @Query("SELECT * FROM notification WHERE user_id = :userId")
    fun getNotificationsByUserId(userId: Int): Flow<Notification?>

    @Query("SELECT liked_post FROM notification WHERE user_id = :userId")
    fun findLikedPostNotification(userId: Int): Flow<Boolean>

    @Query("SELECT new_message FROM notification WHERE user_id = :userId")
    fun findNewMessageNotification(userId: Int): Flow<Boolean>

    @Query("SELECT item_sold FROM notification WHERE user_id = :userId")
    fun findItemSoldNotification(userId: Int): Flow<Boolean>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notification: Notification)

    //@Upsert
    //fun upsert(notification: Notification)

    @Update
    suspend fun update(notification: Notification)

}