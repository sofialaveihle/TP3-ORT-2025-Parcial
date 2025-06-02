package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.carrousel.ButtonCarouselRow
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.MySearchBar
import ar.edu.ort.tp3_ort_2025_parcial.component.list.ProductList
import ar.edu.ort.tp3_ort_2025_parcial.component.text.HomepageText
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun Search(
    viewModel: MainViewModel
){

    val searchText by viewModel.searchText.collectAsState()
    val title = stringResource(R.string.search)
    LaunchedEffect(Unit) {
        viewModel.setTopBar(title)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        MySearchBar(
            placeHolder = stringResource(R.string.location_placeholder),
            value = searchText,
            onValueChange = { viewModel.updateSearchText(it) },
            image = painterResource(id = R.drawable.search_icon)
        )
        Spacer(modifier = Modifier.height(16.dp))
        ButtonCarouselRow()
        HomepageText(
            text = stringResource(R.string.recent)
        )
        ProductList()
    }
}