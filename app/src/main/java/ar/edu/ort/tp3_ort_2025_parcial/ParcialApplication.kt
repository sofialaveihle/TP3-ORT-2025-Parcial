package ar.edu.ort.tp3_ort_2025_parcial

import android.app.Application
import ar.edu.ort.tp3_ort_2025_parcial.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ParcialApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Cuando se crea la app, se crea el objeto Config
        Config.baseUrl = resources.getString(R.string.products_api_base_url)
    }
}