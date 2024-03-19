package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.ui.components.OutlinedTextFieldModel

@Composable
fun CadastroScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientHeaderWithImage()
            Spacer(modifier = Modifier.height(16.dp))
            LoginAndCadastro(navController)
            Spacer(modifier = Modifier.height(16.dp))
            EscolaOrProfissional(navController)
            Spacer(modifier = Modifier.height(8.dp))
            EnderecoCadastro(navController)
            //Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun EscolaOrProfissional(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var areas by remember { mutableStateOf("") }
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
            value = areas,
            label = if (profissionalDestaque) "Áreas de atuação" else "Áreas de interesse",
            placeholder = if (profissionalDestaque) "Digite suas áreas de atuação" else "Digite suas áreas de interesse",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { areas = it}
        )
    }
}

@Composable
fun EnderecoCadastro(navController: NavController) {
    var cep by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf(Endereco("", "", "", "", "")) }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCadastroScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        CadastroScreen(navController = navController)
    }
}