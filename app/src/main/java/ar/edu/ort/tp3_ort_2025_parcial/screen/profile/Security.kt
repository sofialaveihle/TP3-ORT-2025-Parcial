package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.menuitem.MenuItemRow
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel

@Composable
fun Security(
    navController: NavController,
    topBarViewModel: TopAppViewModel
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Security")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.security),
            style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(R.drawable.settings_icon_security, stringResource(R.string.change_password), onClick = { navController.navigate("changePassword") })
        MenuItemRow(R.drawable.settings_icon_security, stringResource(R.string.change_email), onClick = { navController.navigate("changeEmail") })
    }
}
