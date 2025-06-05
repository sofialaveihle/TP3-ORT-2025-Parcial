package ar.edu.ort.tp3_ort_2025_parcial.data.repository

import ar.edu.ort.tp3_ort_2025_parcial.model.Notification
import kotlinx.coroutines.flow.Flow

interface NotificationsRepository {
    fun getAllNotifications(): Flow<List<Notification>>

    fun getNotificationsByUserId(userId: Int): Flow<Notification?>

    fun findLikedPostNotification(userId: Int): Flow<Boolean>

    fun findNewMessageNotification(userId: Int): Flow<Boolean>

    fun findItemSoldNotification(userId: Int): Flow<Boolean>

    suspend fun insert(notification: Notification)

    suspend fun update(notification: Notification)
}