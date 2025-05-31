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
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    navController: NavController,
    topBarViewModel: MainViewModel
){
    val title by topBarViewModel.title

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
        }
    )
}