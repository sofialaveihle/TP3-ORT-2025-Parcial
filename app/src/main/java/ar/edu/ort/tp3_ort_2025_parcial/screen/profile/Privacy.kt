package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel


@Composable
fun Privacy(
    topBarViewModel: TopAppViewModel
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Privacy")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 30.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        PrivacyInfo(stringResource(R.string.privacy_title_terms_of_use), stringResource(R.string.privacy_info_body))
        PrivacyInfo(stringResource(R.string.privacy_title_petapp_service), stringResource(R.string.privacy_info_body))
    }
}

@Composable
private fun PrivacyInfo(title: String,
                        body: String
) {
    Column (modifier = Modifier.padding(vertical = 10.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        )
    }
}

