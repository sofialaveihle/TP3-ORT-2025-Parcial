package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.menuitem.MenuItemRow
import ar.edu.ort.tp3_ort_2025_parcial.component.button.OutlinedButton

@Composable
fun SettingsPage(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.settings_title_account),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(R.drawable.settings_icon_account, "Account", onClick = { navController.navigate("welcome") })
        MenuItemRow(R.drawable.settings_icon_address, "Address", onClick = { navController.navigate("welcome") })
        MenuItemRow(R.drawable.settings_icon_notification, "Notification", onClick = { navController.navigate("notification") })
        MenuItemRow(R.drawable.settings_icon_payment_method, "Payment Method", onClick = { navController.navigate("welcome") })
        MenuItemRow(R.drawable.settings_icon_privacy, "Privacy", onClick = { navController.navigate("privacy") })
        MenuItemRow(R.drawable.settings_icon_security, "Security", onClick = { navController.navigate("security") })
        Text(
            text = stringResource(R.string.settings_title_help),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(R.drawable.settings_icon_contact, "Contact Us", onClick = { navController.navigate("welcome") })
        MenuItemRow(R.drawable.settings_icon_faq, "FAQ", onClick = { navController.navigate("faq") })

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

