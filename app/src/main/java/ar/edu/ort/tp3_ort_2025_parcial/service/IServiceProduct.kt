package ar.edu.ort.tp3_ort_2025_parcial.service

import ar.edu.ort.tp3_ort_2025_parcial.model.Product

interface IServiceProduct {
    suspend fun getProductsByCategoryGroceries(): List<Product>?
    // suspend fun getQuotes(): List<Quote>?
}