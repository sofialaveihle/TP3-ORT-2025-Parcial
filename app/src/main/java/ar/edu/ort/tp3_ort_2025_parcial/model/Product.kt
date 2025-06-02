package ar.edu.ort.tp3_ort_2025_parcial.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val tags: List<String>,
    val images: List<String>
)