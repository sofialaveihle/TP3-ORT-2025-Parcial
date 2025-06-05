package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button3
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import androidx.compose.runtime.getValue
import ar.edu.ort.tp3_ort_2025_parcial.component.card.ActivityContent
import ar.edu.ort.tp3_ort_2025_parcial.component.card.SellerModeContent
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.HomepageViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel


@Composable
fun HomeNotification(
    homepageViewModel: HomepageViewModel,
    topBarViewModel: TopAppViewModel
){
    val selected by homepageViewModel.selectedSection
    val activity = stringResource(R.string.activity)
    val sellerMode = stringResource(R.string.seller_mode)
    val title = stringResource(R.string.notification)
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar(title)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(1.dp, Alignment.CenterHorizontally)
        ) {
            Button3(
                onClick = { homepageViewModel.setSelectedSection(activity) },
                text = activity,
                isSelected = selected == activity
            )
            Button3(
                onClick = { homepageViewModel.setSelectedSection(sellerMode) },
                text = sellerMode,
                isSelected = selected == sellerMode
            )
        }

        when (selected) {
            activity -> {
                ActivityContent()
            }

            sellerMode -> {
                SellerModeContent()
            }
        }
    }
}