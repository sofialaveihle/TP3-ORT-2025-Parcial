package ar.edu.ort.tp3_ort_2025_parcial.component.entrydata

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Red
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.White

@Composable
fun MySearchBar(
    placeHolder: String,
    value: String,
    onValueChange: (String) -> Unit,
    image: Painter
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = image,
                contentDescription = null,
                tint = Gray
            )
        },
        placeholder = {
            Text(
                placeHolder,
                style = MaterialTheme.typography.labelMedium
            )
        },
        modifier = Modifier
            .width(327.dp)
            .height(60.dp)
            .border(
                width = 1.dp,
                color = Gray,
                shape = RoundedCornerShape(16.dp)
            ),
        textStyle = MaterialTheme.typography.labelMedium,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Gray,
            unfocusedBorderColor = Gray,
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            focusedPlaceholderColor = Gray,
            unfocusedPlaceholderColor = Gray,
            focusedTextColor = Gray,
            unfocusedTextColor = Gray,
            cursorColor = Gray,
            errorPlaceholderColor = Red,
            errorBorderColor = Red,
        )
    )
}