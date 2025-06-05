package ar.edu.ort.tp3_ort_2025_parcial.data.repository

import ar.edu.ort.tp3_ort_2025_parcial.model.CreditCard
import ar.edu.ort.tp3_ort_2025_parcial.data.dao.CreditCardDAO
import kotlinx.coroutines.flow.Flow

class CreditCardRepositoryImplementation(private val creditCardDAO: CreditCardDAO): CreditCardRepository  {

    override fun getCreditCardByUserId(userId: Int): Flow<CreditCard?> = creditCardDAO.getCreditCardByUserId(userId)

    override suspend fun insertCreditCard(creditCard: CreditCard)  = creditCardDAO.insert(creditCard)

    override suspend fun updateCreditCard(creditCard: CreditCard) = creditCardDAO.update(creditCard)

}