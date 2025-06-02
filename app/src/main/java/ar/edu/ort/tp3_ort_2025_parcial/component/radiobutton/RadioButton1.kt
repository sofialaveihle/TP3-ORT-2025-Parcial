package ar.edu.ort.tp3_ort_2025_parcial.component.radiobutton

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple

@Preview(showBackground = true)
@Composable
fun RadioButton1Preview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        RadioButton1(label = stringResource(R.string.paypal_radio_button), selected = true, onSelect = {})
        RadioButton1(label = stringResource(R.string.bank_transfer_radio_button), selected = false, onSelect = {})
    }
}

@Composable
fun RadioButton1(
    label: String,
    selected: Boolean,
    onSelect: () -> Unit
) {
    val borderColor = if (selected) Purple else Gray2
    val textColor = if (selected) Purple else Gray

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(1.dp, borderColor, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp)
            .clickable { onSelect() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = textColor,
            style = MaterialTheme.typography.labelMedium
        )

        RadioButton(
            selected = selected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = Purple,
                unselectedColor = Gray2
            )
        )
    }
}

