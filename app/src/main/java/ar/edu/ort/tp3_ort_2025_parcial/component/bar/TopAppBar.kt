package ar.edu.ort.tp3_ort_2025_parcial.component.bar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button5
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text2
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.TopAppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    navController: NavController,
    topBarViewModel: TopAppViewModel
){
    val title by topBarViewModel.title
    val show by topBarViewModel.showFavorite
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    LaunchedEffect(currentRoute) {
        topBarViewModel.updateRoute(currentRoute)
    }

    var favorite by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = {
            Text2(
                text = title,
            )
        },
        navigationIcon = {
            Surface(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(46.dp),
                shape = RoundedCornerShape(16.dp),
                color = White,
                shadowElevation = 8.dp
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.go_back_icon_desc)
                    )
                }
            }
        },
        actions = {
            if (show) {
                Button5(
                    favorite = favorite,
                    onToggle = { favorite = !favorite }
                )
            }
        }
    )
}