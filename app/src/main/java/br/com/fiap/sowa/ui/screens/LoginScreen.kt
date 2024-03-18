package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R

@Composable
fun LoginScreen(navController: NavController) {
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
            EmailAndPasswordFields(navController)
            Spacer(modifier = Modifier.height(16.dp))
            EnterButtons(navController)
            Spacer(modifier = Modifier.height(16.dp))
            ExternalLoginButtons()
            Spacer(modifier = Modifier.weight(1f))
            Footer()
        }
    }
}

@Composable
fun GradientHeaderWithImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
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
fun LoginAndCadastro (navController: NavController) {
    var corLogin by remember { mutableStateOf(Color.Transparent) }
    var corCadastro by remember { mutableStateOf(Color.Transparent) }

    if (navController.currentBackStackEntry?.destination?.route == "login") {
        corLogin = Color.Transparent
        corCadastro = Color(0xFF4876AD)
    } else if (navController.currentBackStackEntry?.destination?.route == "cadastro") {
        corLogin = Color(0xFF4876AD)
        corCadastro = Color.Transparent
    }

    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(Color(0xFF3A7CCB), Color(0xFF1A4980)),
                    startX = 0f,
                    endX = 900f
                )
            )
            .padding(horizontal = 45.dp)
            .height(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(corLogin),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(text = "Login", fontSize = 12.sp, color = Color.White)
        }

        Button(
            onClick = { navController.navigate("cadastroEscola") },
            colors = ButtonDefaults.buttonColors(corCadastro),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Cadastro", fontSize = 12.sp, color = Color.White)
        }
    }
}

@Composable
fun EmailAndPasswordFields(navController: NavController){
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 64.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { letra ->
                email = letra
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Digite seu email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(7.dp))

        OutlinedTextField(
            value = senha.replace(Regex("."), "*"),
            onValueChange = { letra ->
                senha = letra
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            label = { Text(text = "Senha") },
            placeholder = { Text(text = "Digite sua senha") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.eye),
                    contentDescription = "Ícone de olho.",
                    modifier = Modifier.size(20.dp)
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

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

@Composable
fun EnterButtons(navController: NavController) {
    Button(
        onClick = { navController.navigate("home") },
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        modifier = Modifier
            .width(270.dp)
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(Color(0xFF3A7CCB), Color(0xFF1A4980)),
                    startX = 0f,
                    endX = 900f
                ),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = "ENTRAR",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun ExternalLoginButtons() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding
                (vertical = 8.dp, horizontal = 60.dp)
    ) {
        Divider(modifier = Modifier.weight(1f), color = Color.Gray)
        Text(
            text = "OU",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Divider(modifier = Modifier.weight(1f), color = Color.Gray)
    }

    Spacer(modifier = Modifier.height(8.dp))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SocialButton(
            icon = R.drawable.google_icon,
            text = "Entrar com Google"
        )

        Spacer(modifier = Modifier.height(12.dp))

        SocialButton(
            icon = R.drawable.facebook_icon,
            text = "Entrar com Facebook"
        )
    }
}

@Composable
fun SocialButton(icon: Int, text: String) {
    OutlinedButton(
        onClick = { /* Lógica de login externo */ },
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier.width(270.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Social Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text, color = Color.DarkGray)
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        LoginScreen(navController = navController)
    }
}
