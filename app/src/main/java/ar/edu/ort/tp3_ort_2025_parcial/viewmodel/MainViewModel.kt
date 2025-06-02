package ar.edu.ort.tp3_ort_2025_parcial.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3_ort_2025_parcial.model.Product
import ar.edu.ort.tp3_ort_2025_parcial.navigation.getSectionForRoute
import ar.edu.ort.tp3_ort_2025_parcial.service.GetServiceProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //Inject: que a mi ViewModel, Hilt va a inyectar un objeto GetServiceQuotes, capa de servicios
    //
    private val getProductsService: GetServiceProduct
) : ViewModel() {

    var products by mutableStateOf<List<Product>>(emptyList())

    //Definimos atributos que manejan la mutabilidad del estado
    private var product = mutableStateOf(value = "Cargando...")
    private var description = mutableStateOf(value = "")
    private var category = mutableStateOf(value = "")
    private var price = mutableStateOf(value = "")

    //Función llamada en MainActivity
    fun loadProducts() {
        /*ViewModelScope: espacio de corrutinas.
        Función que convierte todo lo que contiene dentro, en asincrónico.
        Las corrutinas son ejecuciones en segundo plano que no se ejecutan con el main thread

        Suspended functions: la única forma de ejecutarlas, es fuera del scope principal porque
        si se deja en el thread principal se corre el riesgo de que la API tarde en responder,
        se cuelgue la app y Android la cierre.
        */
        viewModelScope.launch {
            val productList = getProductsService.invoke() //Devuelve lista de productos
            if (!productList.isNullOrEmpty() && productList.isNotEmpty()) {

                products = productList

                product.value = products[0].title
                description.value = products[0].description
                category.value = products[0].category
                price.value = products[0].price.toString()
            }
        }
    }

    // Top App Bar
    private val _title = mutableStateOf("")
    val title: State<String> = _title

    fun setTopBar(title: String) {
        _title.value = title
    }

    // Bottom App Bar
    private val _currentSection = mutableStateOf<String?>(null)
    val currentSection: State<String?> = _currentSection

    fun updateSectionFromRoute(route: String?) {
        _currentSection.value = getSectionForRoute(route)
    }

    // Notification -> Estados de switches
    // como la logica no es complicada uso el mismo view model, se puede hacer un achivo separado
    var notificationSettings = mutableStateMapOf(
        "Liked Post" to true,
        "New Message" to true,
        "Item Sold" to true
    )
        private set

    fun toggleNotification(key: String, value: Boolean) {
        notificationSettings[key] = value
    }

}