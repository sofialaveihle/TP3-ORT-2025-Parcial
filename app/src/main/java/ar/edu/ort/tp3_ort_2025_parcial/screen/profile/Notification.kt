package ar.edu.ort.tp3_ort_2025_parcial.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun Notification(
    viewModel: MainViewModel = viewModel()
) {
    val settings = viewModel.notificationSettings
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.settings_title_social),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(
            notificationItem = "Liked Post",
            checked = settings["Liked Post"] ?: true,
            onCheckedChange = { viewModel.toggleNotification("Liked Post", it) }
        )

        MenuItemRow(
            notificationItem = "New Message",
            checked = settings["New Message"] ?: true,
            onCheckedChange = { viewModel.toggleNotification("New Message", it) }
        )

        Text(
            text = stringResource(R.string.settings_title_store),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(
            notificationItem = "Item Sold",
            checked = settings["Item Sold"] ?: true,
            onCheckedChange = { viewModel.toggleNotification("Item Sold", it) }
        )
    }
}

@Composable
private fun MenuItemRow(
    notificationItem: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = notificationItem,
            style = MaterialTheme.typography.bodyMedium
        )

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}
