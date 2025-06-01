package ar.edu.ort.tp3_ort_2025_parcial.screen.welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button1
import ar.edu.ort.tp3_ort_2025_parcial.component.carrousel.Carousel
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Title1
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun Welcome(navController: NavController) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        val screenHeight = maxHeight
        val screenWidth = maxWidth

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title1(
                text = stringResource(R.string.welcome_title),
                modifier = Modifier
                    .padding(top = screenHeight * 0.05f, end = 16.dp)
                    .align(Alignment.Start),
                textAlign = TextAlign.Left
            )

            Carousel(
                modifier = Modifier
                    .fillMaxWidth()
            )

//            Button1(
//                text = stringResource(R.string.welcome_button_text),
//                onClick = { navController.navigate(Screens.Login.screen) },
//                modifier = Modifier
//                    .width(screenWidth * 0.85f)
//                    .height(56.dp)
//            )
            Button1(
                text = stringResource(R.string.welcome_button_text),
                onClick = { navController.navigate(Screens.ProductPrueba.screen) },
                modifier = Modifier
                    .width(screenWidth * 0.85f)
                    .height(56.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
