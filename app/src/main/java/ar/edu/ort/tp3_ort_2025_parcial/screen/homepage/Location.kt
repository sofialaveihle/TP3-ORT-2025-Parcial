package ar.edu.ort.tp3_ort_2025_parcial.screen.homepage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.entrydata.MySearchBar
import ar.edu.ort.tp3_ort_2025_parcial.component.text.HomepageText
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.MainViewModel

@Composable
fun Location(
    onLocationSelected: (String) -> Unit,
    viewModel: MainViewModel
) {
    val searchText by viewModel.searchText.collectAsState()

    Column(modifier = Modifier.padding(24.dp)) {

        HomepageText(stringResource(R.string.location))

        Spacer(modifier = Modifier.height(16.dp))

        MySearchBar(
            placeHolder = stringResource(R.string.location_placeholder),
            value = searchText,
            onValueChange = { viewModel.updateSearchText(it) },
            image = painterResource(id = R.drawable.search_icon)
        )

        Spacer(modifier = Modifier.height(32.dp))

        HorizontalDivider(
            thickness = 1.dp,
            color = Gray,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onLocationSelected("Current Location") }
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location_icon),
                        contentDescription = stringResource(R.string.location_desc)
                    )
                    Text(
                        text = stringResource(R.string.track_your_location),
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = stringResource(R.string.location_desc),
                    color = Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}