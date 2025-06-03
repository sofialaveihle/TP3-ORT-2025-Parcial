package ar.edu.ort.tp3_ort_2025_parcial.repository

import ar.edu.ort.tp3_ort_2025_parcial.model.room.CreditCardEntity
import ar.edu.ort.tp3_ort_2025_parcial.dao.CreditCardDAO
import javax.inject.Inject

class CreditCardRepository @Inject constructor(
    private val creditCardDao: CreditCardDAO
) {

    suspend fun saveCreditCard(card: CreditCardEntity) {
        creditCardDao.insertCard(card)
    }

    suspend fun getCreditCard(userId: String): CreditCardEntity? {
        return creditCardDao.getCardByUserId(userId)
    }

}