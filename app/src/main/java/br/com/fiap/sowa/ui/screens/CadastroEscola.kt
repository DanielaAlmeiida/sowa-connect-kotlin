package br.com.fiap.sowa.ui.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.ui.components.OutlinedTextFieldModel

@Composable
fun CadastroEscola(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientHeaderWithImage()
            Spacer(modifier = Modifier.height(16.dp))
            LoginAndCadastro(navController)
            Spacer(modifier = Modifier.height(16.dp))
            EscolaOrProfissional(navController)
            Spacer(modifier = Modifier.height(8.dp))
            BuscarCep(navController)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun EscolaOrProfissional(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var tipoEscola by remember { mutableStateOf("") }
    var escolaDestaque by remember { mutableStateOf(true) }
    var profissionalDestaque by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 64.dp)
    )

    {
        Text(
            text = "Você é um(a)",
            fontSize = 15.sp,
            color = Color.Black,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = {
                        escolaDestaque = true
                        profissionalDestaque = false
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = if (escolaDestaque) ButtonDefaults.buttonColors(colorResource(id = R.color.bluePrincipal)) else
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                        border = BorderStroke(1.dp, colorResource(id = R.color.bluePrincipal)),
                    modifier = Modifier
                        .width(100.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "Escola",
                        color = if (escolaDestaque) Color.White else colorResource(id = R.color.bluePrincipal),
                        fontSize = 12.sp,
                    )
                }

                Button(
                    onClick = {
                        escolaDestaque = false
                        profissionalDestaque = true
                    },
                    colors = if (profissionalDestaque) ButtonDefaults.buttonColors(colorResource(id = R.color.bluePrincipal)) else
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                    border = BorderStroke(1.dp, colorResource(id = R.color.bluePrincipal)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "Profissional",
                        color = if (profissionalDestaque) Color.White else colorResource(id = R.color.bluePrincipal),
                        fontSize = 12.sp,
                    )
                }
            }
        }
        OutlinedTextFieldModel(
            value = nome,
            label = "Nome",
            placeholder = "Digite o nome da escola",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { nome = it}
        )
        OutlinedTextFieldModel(
            value = tipoEscola,
            label = "Tipo de escola",
            placeholder = "Digite o tipo de escola",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { tipoEscola = it}
        )
    }
}

@Composable
fun BuscarCep(navController: NavController) {
    var isFocused by remember { mutableStateOf(false) }
    var cep by remember { mutableStateOf(TextFieldValue()) }
    var cepValido by remember { mutableStateOf(false) }
    var endereco by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 64.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(1.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = cep,
                    onValueChange = { newValue ->
                        val formattedCep = formatarCEP(newValue.text)
                        cep = TextFieldValue(text = formattedCep, selection = TextRange(formattedCep.length))
                        cepValido = validarCEP(formattedCep)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .onFocusChanged { focusState ->
                            isFocused = focusState.isFocused
                        },
                    shape = RoundedCornerShape(5.dp),
                    label = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "CEP")
                            Text(
                                text = "*",
                                color = Color.Red,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            if (!isFocused && cep.text.isEmpty()) {
                                Text(
                                    text = "",
                                    color = Color.Gray,
                                    textAlign = TextAlign.End,
                                    fontSize = 13.sp,
                                )
                            }
                        }
                    }
                )
                Button(
                    onClick = { /* Ação ao clicar no botão */ },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.bluePrincipal)),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .height(40.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "Buscar",
                        color = Color.White,
                        fontSize = 12.sp,
                    )
                }
            }
        }

        if (!cepValido && cep.text.isNotEmpty()) {
            Text(
                text = "CEP inválido",
                color = Color.Red,
                textAlign = TextAlign.Left,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                /*
                Se der certo a consulta ao CEP, podemos deixar o campo de endereço disabled?
                (pois preencherá automático)
                */
                OutlinedTextFieldModel(
                    value = endereco,
                    label = "Endereço",
                    placeholder = "Digite o endereço",
                    modifier = Modifier.width(190.dp),
                    keyboardType = KeyboardType.Text,
                    atualizarValor = { endereco = it}
                )
                OutlinedTextFieldModel(
                    value = numero,
                    label = "Número",
                    placeholder = "Digite o número",
                    modifier = Modifier.width(80.dp),
                    keyboardType = KeyboardType.Number,
                    atualizarValor = { numero = it}
                )
            }
        }
    }

}

fun validarCEP(cep: String): Boolean {
    val regex = Regex("\\d{5}-\\d{3}")
    return regex.matches(cep)
}

fun formatarCEP(cepValue: String): String {
    // Define a expressão regular para capturar os grupos de dígitos
    val cepRegex = Regex("""^(\d{5})-?(\d{3})$""")

    return if (cepValue.length > 5) {
        // Formata o CEP conforme o padrão "11111-111"
        cepValue.take(8).replace(cepRegex, "$1-$2")
    } else {
        cepValue
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCadastroEscola() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        CadastroEscola(navController = navController)
    }
}
