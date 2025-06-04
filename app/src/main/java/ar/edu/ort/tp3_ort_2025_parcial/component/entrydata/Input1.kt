package ar.edu.ort.tp3_ort_2025_parcial.component.entrydata

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray2
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Purple
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Red
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Preview
@Composable
fun Input1Preview() {
    var text by remember { mutableStateOf("") }
    Input1("input1", text, onValueChange = { text = it }, false)
}


@Composable
fun Input1(placeHolder: String, value: String, onValueChange: (String) -> Unit, isPassword: Boolean, isError: Boolean = false) {
    val passwordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        isError = isError,
        placeholder = {
            Text(
                placeHolder,
                style = MaterialTheme.typography.labelMedium
            )
        },
        visualTransformation = if (!passwordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        textStyle = MaterialTheme.typography.labelMedium,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Purple,
            unfocusedBorderColor = Gray2,
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            focusedPlaceholderColor = Purple,
            unfocusedPlaceholderColor = Gray2,
            focusedTextColor = Purple,
            unfocusedTextColor = Purple,
            disabledTextColor = Gray2,
            cursorColor = Purple,
            errorPlaceholderColor = Red,
            errorBorderColor = Red,
        )
    )
}