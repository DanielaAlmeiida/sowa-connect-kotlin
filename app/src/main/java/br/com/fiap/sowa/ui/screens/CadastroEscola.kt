package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun EscolaOrProfissional(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
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
        Spacer(modifier = Modifier.height(7.dp))

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
                    modifier = Modifier
                        .width(100.dp)
                        .height(35.dp)
                        .background(if (escolaDestaque) Color.Blue else Color.White)
                ) {
                    Text(
                        text = "Escola",
                        color = if (escolaDestaque) Color.White else Color.Blue,
                        fontSize = 12.sp,
                    )
                }

                Button(
                    onClick = {
                        escolaDestaque = false
                        profissionalDestaque = true
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(35.dp)
                        .background(if (profissionalDestaque) Color.Blue else Color.White)
                ) {
                    Text(
                        text = "Profissional",
                        color = if (profissionalDestaque) Color.White else Color.Blue,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}
//        Spacer(modifier = Modifier.height(7.dp))
//
//        OutlinedTextField(
//            value = senha.replace(Regex("."), "*"),
//            onValueChange = { letra ->
//                senha = letra
//            },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(10.dp),
//            label = { Text(text = "Tipo de escola") },
//            placeholder = { Text(text = "Digite o tipo de escola") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            trailingIcon = {
//            }
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//       }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCadastroEscola() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        CadastroEscola(navController = navController)
    }
}
