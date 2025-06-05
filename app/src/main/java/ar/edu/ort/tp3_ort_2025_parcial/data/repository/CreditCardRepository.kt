package ar.edu.ort.tp3_ort_2025_parcial.data.repository

import ar.edu.ort.tp3_ort_2025_parcial.model.CreditCard
import kotlinx.coroutines.flow.Flow

interface CreditCardRepository {

    fun getCreditCardByUserId(userId: Int): Flow<CreditCard?>

    fun findCreditCardNumberByUserId(userId: Int): Flow<String>

    fun findCreditCardNameByUserId(userId: Int): Flow<String>

    fun findCreditCardExpirationByUserId(userId: Int): Flow<String>

    suspend fun updateCreditCard(creditCard: CreditCard)

    suspend fun insertCreditCard(creditCard: CreditCard)


}