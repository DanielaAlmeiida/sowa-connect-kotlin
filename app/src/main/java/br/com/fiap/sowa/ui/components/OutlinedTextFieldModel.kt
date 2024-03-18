package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextFieldModel(
    value: String,
    label: String,
    placeholder: String,
    modifier: Modifier,
    keyboardType: KeyboardType,
    atualizarValor: (String) -> Unit,
    trailingIcon: (@Composable () -> Unit)? = null // tornando o parâmetro opcional
) {
    OutlinedTextField(
        value = value,
        label = {
            Row {
                Text(text = label)
                Text(text = "*", color = Color.Red) } },
        placeholder = { Text(text = placeholder) },
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        onValueChange = atualizarValor,
        shape = RoundedCornerShape(5.dp),
        trailingIcon = trailingIcon
    )
    Spacer(modifier = Modifier.height(7.dp))
}