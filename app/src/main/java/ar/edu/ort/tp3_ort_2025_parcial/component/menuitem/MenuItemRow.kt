package ar.edu.ort.tp3_ort_2025_parcial.component.menuitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R

@Composable
fun MenuItemRow(
    icon: Int,
    menuItem: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SettingMenuIcon(icon)
            Text(
                text = menuItem,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Composable
fun SettingMenuIcon(icon: Int) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .padding(end = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(painterResource(R.drawable.settings_icon_background), contentDescription = null)
        Image(painterResource(icon), contentDescription = null)
    }
}