package ar.edu.ort.tp3_ort_2025_parcial.component.entrydata

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.R
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 4.dp, start = 4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.info_square),
                contentDescription = stringResource(R.string.info_square_img),
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(R.string.required_field_text),
                color = Red,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

