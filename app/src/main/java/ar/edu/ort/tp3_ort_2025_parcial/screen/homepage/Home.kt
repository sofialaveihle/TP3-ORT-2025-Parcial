package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button4
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import androidx.compose.runtime.getValue
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White
import androidx.compose.ui.platform.LocalConfiguration
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens


@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val isSheetOpen by viewModel.isSheetOpen
    val selectedLocation by viewModel.selectedLocation

    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { viewModel.closeSheet() },
            sheetState = sheetState,
            containerColor = White,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            val screenHeight = LocalConfiguration.current.screenHeightDp.dp
            Box(
                modifier = Modifier.height(screenHeight * 0.75f)
            ) {
                Location(
                    onLocationSelected = viewModel::updateLocation,
                    viewModel = viewModel
                )
            }
        }
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.clickable { viewModel.openSheet() }
            ) {
                Text(
                    text = "Location",
                    color = Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = selectedLocation,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button4(
                    image = painterResource(id = R.drawable.search_icon),
                    onClick = { navController.navigate(Screens.Home.screen) }
                )
                Button4(
                    image = painterResource(id = R.drawable.notification_icon),
                    onClick = { navController.navigate(Screens.Home.screen) }
                )
            }
        }
    }
}