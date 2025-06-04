package ar.edu.ort.tp3_ort_2025_parcial.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ar.edu.ort.tp3_ort_2025_parcial.data.dao.NotificationDAO
import ar.edu.ort.tp3_ort_2025_parcial.model.Notification

@Database(entities = [Notification::class], version = 1, exportSchema = false)
abstract class PetAppDatabase: RoomDatabase() {
        abstract fun notificationDao(): NotificationDAO
        companion object {
                @Volatile
                private var Instance: PetAppDatabase? = null

                fun getDatabase(context: Context): PetAppDatabase {
                        return Instance ?: synchronized(this) {
                                Room.databaseBuilder(context, PetAppDatabase::class.java, "PetAppDb")
                                        .build()
                                        .also { Instance = it }
                        }
                }
        }
}