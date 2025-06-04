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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.NotificationViewModel
import ar.edu.ort.tp3_ort_2025_parcial.model.Notification


@Composable
fun Notification(
    topBarViewModel: MainViewModel,
    viewModel: NotificationViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        topBarViewModel.setTopBar("Notification")
    }

    val notificationState by viewModel.notificationSettings.collectAsState()

    val settings = notificationState ?: Notification(
        user_id = 1,
        likedPost = true,
        newMessage = true,
        itemSold = true
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.settings_title_social),
            style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(
            notificationItem = "Liked Post",
            checked = settings.likedPost,
            onCheckedChange = { viewModel.toggleNotification("Liked Post", it) }
        )

        MenuItemRow(
            notificationItem = "New Message",
            checked = settings.newMessage,
            onCheckedChange = { viewModel.toggleNotification("New Message", it) }
        )

        Text(
            text = stringResource(R.string.settings_title_store),
            style = MaterialTheme.typography.displayMedium.copy(color = Color.Black),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
        MenuItemRow(
            notificationItem = "Item Sold",
            checked = settings.itemSold,
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
