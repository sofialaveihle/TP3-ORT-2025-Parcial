package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button3
import androidx.compose.runtime.getValue
import ar.edu.ort.tp3_ort_2025_parcial.component.card.ActivityContent
import ar.edu.ort.tp3_ort_2025_parcial.component.card.SellerModeContent
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.HomepageViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3


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
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(45.dp)
                .background(
                    color = Gray3,
                    shape = RoundedCornerShape(40.dp)
                )
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Button3(
                    onClick = { homepageViewModel.setSelectedSection(activity) },
                    text = activity,
                    isSelected = selected == activity,
                    modifier = Modifier.weight(1f)
                )
                Button3(
                    onClick = { homepageViewModel.setSelectedSection(sellerMode) },
                    text = sellerMode,
                    isSelected = selected == sellerMode,
                    modifier = Modifier.weight(1f)
                )
            }
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