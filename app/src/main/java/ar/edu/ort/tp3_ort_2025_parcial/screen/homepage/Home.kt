package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.button.Button4
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import ar.edu.ort.tp3_ort_2025_parcial.component.banner.PromoBanner
import ar.edu.ort.tp3_ort_2025_parcial.component.carrousel.ButtonCarouselRow
import ar.edu.ort.tp3_ort_2025_parcial.component.grid.ProductGrid
import ar.edu.ort.tp3_ort_2025_parcial.component.text.HomepageText
import ar.edu.ort.tp3_ort_2025_parcial.component.text.TextLink
import ar.edu.ort.tp3_ort_2025_parcial.screen.Screens
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.HomepageViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.ProductViewModel
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.SearchBarViewModel


@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    homepageViewModel: HomepageViewModel,
    productViewModel: ProductViewModel,
    searchViewModel: SearchBarViewModel,
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val isSheetOpen by homepageViewModel.isSheetOpen
    val selectedLocation by homepageViewModel.selectedLocation
    val products = productViewModel.products
    val screenHeightDp = LocalConfiguration.current.screenHeightDp

    LaunchedEffect(Unit) {
        productViewModel.loadProducts()
    }

    if (isSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = { homepageViewModel.closeSheet() },
            sheetState = sheetState,
            containerColor = White,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            val screenHeight = LocalConfiguration.current.screenHeightDp.dp
            Box(
                modifier = Modifier.height(screenHeight * 0.75f)
            ) {
                Location(
                    onLocationSelected = homepageViewModel::updateLocation,
                    searchViewModel = searchViewModel
                )
            }
        }
    }

    Column(
        modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState())
    ) {
        // Location Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.clickable { homepageViewModel.openSheet() }
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = stringResource(R.string.location),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Gray,
                        fontSize = 12.sp
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = stringResource(R.string.arrow_down),
                        tint = Gray
                    )
                }
                Text(
                    text = selectedLocation,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 16.sp,
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button4(
                    image = painterResource(id = R.drawable.search_icon),
                    onClick = { navController.navigate(Screens.Search.screen) }
                )
                Button4(
                    image = painterResource(id = R.drawable.notification_icon),
                    onClick = { navController.navigate(Screens.HomeNotifications.screen) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Banner
        PromoBanner(
            backgroundResId = R.drawable.banner_background,
            productResId = R.drawable.banner_image
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Category
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomepageText(
                text = stringResource(R.string.category)
            )
            TextLink(
                text = stringResource(R.string.view_all),
                onClick = { navController.navigate(Screens.Home.screen) }
            )
        }
        ButtonCarouselRow()

        Spacer(modifier = Modifier.height(16.dp))

        // Best Seller
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomepageText(
                text = stringResource(R.string.best_seller)
            )
            TextLink(
                text = stringResource(R.string.view_all),
                onClick = { navController.navigate(Screens.BestSeller.screen)}
            )
        }
        ProductGrid(
            navController = navController,
            productList = products,
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeightDp * 0.5f).dp)
        )
    }
}