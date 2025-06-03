package ar.edu.ort.tp3_ort_2025_parcial.repository

import ar.edu.ort.tp3_ort_2025_parcial.dao.UserDAO
import ar.edu.ort.tp3_ort_2025_parcial.model.room.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDAO: UserDAO) {
    suspend fun saveUser(user: UserEntity) = userDAO.insertUser(user)
    suspend fun getUser(email: String) = userDAO.getUserByEmail(email)
}