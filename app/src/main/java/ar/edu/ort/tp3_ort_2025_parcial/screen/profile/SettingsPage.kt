package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.menuitem.MenuItemRow
import ar.edu.ort.tp3_ort_2025_parcial.component.button.OutlinedButton
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel

@Composable
fun SettingsPage(
    navController: NavController,
    topBarViewModel: TopAppViewModel
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Settings Page")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 30.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.account),
            style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(R.drawable.settings_icon_account, stringResource(R.string.account), onClick = { navController.navigate("profileUserEdit") })
        MenuItemRow(R.drawable.settings_icon_address, stringResource(R.string.address), onClick = { navController.navigate("address") })    // este item no tiene pantalla asignada en figma
        MenuItemRow(R.drawable.settings_icon_notification, stringResource(R.string.notification), onClick = { navController.navigate("notification") })
        MenuItemRow(R.drawable.settings_icon_payment_method, stringResource(R.string.payment_method), onClick = { navController.navigate("addPaymentMethod") })
        MenuItemRow(R.drawable.settings_icon_privacy, stringResource(R.string.privacy), onClick = { navController.navigate("privacy") })
        MenuItemRow(R.drawable.settings_icon_security, stringResource(R.string.security), onClick = { navController.navigate("security") })
        Text(
            text = stringResource(R.string.help),
            style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(R.drawable.settings_icon_contact, stringResource(R.string.contact_us), onClick = { navController.navigate("contactUs") })    // este item no tiene pantalla asignada en figma
        MenuItemRow(R.drawable.settings_icon_faq, stringResource(R.string.faq), onClick = { navController.navigate("faq") })

        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            OutlinedButton(
                onClick = { navController.navigate("login") },
                text = stringResource(R.string.log_out)
            )
        }
    }
}

