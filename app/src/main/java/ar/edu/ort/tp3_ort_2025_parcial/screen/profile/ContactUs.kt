package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel

@Composable
fun ContactUs(
    topBarViewModel: TopAppViewModel
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Contact Us")
    }
}