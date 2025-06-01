package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun Address(
    topBarViewModel: MainViewModel
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Address")
    }
}
