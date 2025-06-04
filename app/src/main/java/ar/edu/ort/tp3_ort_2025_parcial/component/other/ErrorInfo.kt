package ar.edu.ort.tp3_ort_2025_parcial.component.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Red

@Composable
fun ErrorInfo(modifier: Modifier, error: String = "error") {
    Row(
        modifier = modifier.padding(top = 4.dp, start = 4.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.info_square),
            contentDescription = stringResource(R.string.info_square_img),
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = error,
            color = Red,
            style = MaterialTheme.typography.labelSmall
        )
    }
}