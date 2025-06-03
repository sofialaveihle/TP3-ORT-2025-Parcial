package ar.edu.ort.tp3_ort_2025_parcial.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.ort.tp3_ort_2025_parcial.dao.CreditCardDAO
import ar.edu.ort.tp3_ort_2025_parcial.dao.UserDAO

@Database(
    entities = [UserEntity::class, CreditCardEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun creditCardDao(): CreditCardDAO
}