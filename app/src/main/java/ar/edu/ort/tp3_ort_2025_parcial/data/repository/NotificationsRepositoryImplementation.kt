package ar.edu.ort.tp3_ort_2025_parcial.data.repository

import ar.edu.ort.tp3_ort_2025_parcial.data.dao.NotificationDAO
import ar.edu.ort.tp3_ort_2025_parcial.model.Notification
import kotlinx.coroutines.flow.Flow

class NotificationsRepositoryImplementation(private val notificationDao: NotificationDAO): NotificationsRepository {
    override fun getAllNotifications(): Flow<List<Notification>> = notificationDao.getAllNotifications()

    override fun getNotificationsByUserId(userId: Int): Flow<Notification?> = notificationDao.getNotificationsByUserId(userId)

    override fun findLikedPostNotification(userId: Int): Flow<Boolean>  = notificationDao.findLikedPostNotification(userId)

    override fun findNewMessageNotification(userId: Int): Flow<Boolean> = notificationDao.findNewMessageNotification(userId)

    override fun findItemSoldNotification(userId: Int): Flow<Boolean>  = notificationDao.findItemSoldNotification(userId)

    override suspend fun insert(notification: Notification)  = notificationDao.insert(notification)

    override suspend fun update(notification: Notification) = notificationDao.update(notification)

}