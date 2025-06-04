package ar.edu.ort.tp3_ort_2025_parcial.component.entrydata

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.component.other.ErrorInfo
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Red
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Composable
fun InputCVV(
    value: String,
    onValueChange: (String) -> Unit,
    showError: Boolean
) {
    var isFocused by remember { mutableStateOf(false) }

    val textColor = if (isFocused || value.isNotEmpty()) Purple else Gray2

    OutlinedTextField(
        value = value,
        onValueChange = {
            val digitsOnly = it.filter { c -> c.isDigit() }
            if (digitsOnly.length <= 4) {
                onValueChange(digitsOnly)
            }
        },
        placeholder = {
            Text(
                text = stringResource(R.string.cvv_title_button),
                style = MaterialTheme.typography.labelMedium,
                color = if (showError) Red else if (isFocused) Purple else Gray2
            )
        },
        singleLine = true,
        isError = showError,
        textStyle = MaterialTheme.typography.labelMedium.copy(color = textColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            },
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Purple,
            unfocusedBorderColor = Gray2,
            errorBorderColor = Red,
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            cursorColor = Purple,
            focusedTextColor = Purple,
            unfocusedTextColor = Gray2,
            focusedPlaceholderColor = Purple,
            unfocusedPlaceholderColor = Gray2,
            errorPlaceholderColor = Red
        )
    )

    if (showError) {
        ErrorInfo(
            modifier = Modifier.padding(top = 4.dp, start = 4.dp),
            stringResource(R.string.required_field_text)
        )
    }
}

