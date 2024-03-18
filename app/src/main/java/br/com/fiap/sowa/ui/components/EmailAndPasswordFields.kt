package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.sowa.R

@Composable
fun EmailAndPasswordFields(navController: NavController){
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 64.dp)
    ) {
        OutlinedTextFieldModel(
            value = email,
            label = "Email",
            placeholder = "Digite seu email",
            modifier = Modifier,
            keyboardType = KeyboardType.Email,
            atualizarValor = { email = it}
        )

        OutlinedTextFieldModel(
            value = senha.replace(Regex("."), "*"),
            label = "Senha",
            placeholder = "Digite sua senha",
            modifier = Modifier,
            keyboardType = KeyboardType.Password,
            atualizarValor = { senha = it},
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.eye),
                    contentDescription = "Ícone de olho.",
                    modifier = Modifier.size(20.dp)
                )
            }
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(32.dp)
                .width(110.dp)
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            contentPadding = PaddingValues(horizontal = 0.dp)
        ) {
            Text(
                text = "Esqueceu a senha?",
                fontSize = 12.sp,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                color = Color.Gray,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}