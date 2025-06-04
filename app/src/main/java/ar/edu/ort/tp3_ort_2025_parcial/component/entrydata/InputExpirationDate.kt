package ar.edu.ort.tp3_ort_2025_parcial.component.entrydata

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Red
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Composable
fun InputExpirationDate(
    value: String,
    onValueChange: (String) -> Unit
) {
    val isFocused = remember { mutableStateOf(false) }
    val textColor = if (value.isNotEmpty() || isFocused.value) Purple else Gray2

    OutlinedTextField(
        value = value,
        onValueChange = {
            // Elimina lo que no sean números
            val cleaned = it.filter { c -> c.isDigit() }
            // Formatea el texto como MM/AA
            val formatted = when {
                cleaned.length <= 2 -> cleaned
                cleaned.length <= 4 -> "${cleaned.substring(0, 2)}/${cleaned.substring(2)}"
                else -> "${cleaned.substring(0, 2)}/${cleaned.substring(2, 4)}"
            }
            if (formatted.length <= 5) {
                onValueChange(formatted)
            }
        },
        singleLine = true,
        placeholder = {
            Text(
                text = stringResource(R.string.expired_title_button),
                style = MaterialTheme.typography.labelMedium,
                color = if (isFocused.value) Purple else Gray2
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            }
            .border(1.dp, if (isFocused.value) Purple else Gray2, RoundedCornerShape(16.dp)),
        textStyle = MaterialTheme.typography.labelMedium.copy(color = textColor),
        shape = RoundedCornerShape(16.dp),
        visualTransformation = VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            cursorColor = Purple,
            errorPlaceholderColor = Red,
            errorBorderColor = Red,
            focusedTextColor = Color.Unspecified,
            unfocusedTextColor = Color.Unspecified
        )
    )
}