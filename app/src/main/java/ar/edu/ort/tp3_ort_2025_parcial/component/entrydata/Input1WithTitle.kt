package ar.edu.ort.tp3_ort_2025_parcial.component.entrydata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.ort.tp3_ort_2025_parcial.component.text.Text1

@Preview(showSystemUi = true)
@Composable
fun Input1WithTitlePreview(){
    var text by remember { mutableStateOf("") }
    Input1WithTitle(
        text = "Name",
        value = "Name",
        onValueChange = { text = it },
        isPassword = false
    )
}

//Used in Account, ChangePassword and ChangeEmail screens
@Composable
fun Input1WithTitle(
    text: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        Text1(
            text = text,
            textAlign = TextAlign.Left
        )
        Input1(
            placeHolder = text,
            value = value,
            onValueChange = onValueChange,
            isPassword = isPassword
        )
    }

}
