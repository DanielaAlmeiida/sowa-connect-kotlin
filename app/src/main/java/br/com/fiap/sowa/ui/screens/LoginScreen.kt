package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.sowa.R


@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientHeaderWithImage()
            Spacer(modifier = Modifier.height(16.dp))
            EmailAndPasswordFields()
            Spacer(modifier = Modifier.height(16.dp))
            EnterButtons(navController)
            Spacer(modifier = Modifier.height(16.dp))
            ExternalLoginButtons()
            Spacer(modifier = Modifier.weight(1f))
            Footer()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GradientHeaderWithImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(Color(0xFF3A7CCB), Color(0xFF1A4980)),
                    startX = 0f,
                    endX = 900f
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.sowa_logo),
                contentDescription = "Imagem de cabeçalho",
                modifier = Modifier
                    .size(150.dp)
            )
        }
    }
}

@Composable
fun EmailAndPasswordFields() {

    var email by remember {
        mutableStateOf("")
    }
    var senha by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        TextField(
            value = email,
            onValueChange = { letra ->
                email = letra
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Digite seu email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = senha.replace(Regex("."), "*"),
            onValueChange = { letra ->
                senha = letra
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Senha")
            },
            placeholder = {
                Text(text = "Digite sua senha")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }
}

@Composable
fun EnterButtons(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                /* Lógica de autenticação */
                navController.navigate("home")
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.width(300.dp)
        ) {
            Text(text = "ENTRAR", fontSize = 18.sp, color = Color.White)
        }
    }
}

@Composable
fun ExternalLoginButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Botão para entrar com Google
        Button(
            onClick = { /* Lógica de entrar com Google */ },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.width(300.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Entrar com Google",
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = { /* Lógica de entrar com Google */ },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.width(300.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.facebook_icon),
                    contentDescription = "Facebook Logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Entrar com Facebook",
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun Footer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(Color(0xFF3A7CCB), Color(0xFF1A4980)),
                    startX = 0f,
                    endX = 900f
                )
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.sowa_logo),
            contentDescription = "Logo Sowa",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Sowa Connect",
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "© Todos os direitos reservados 2023",
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
    }
}
