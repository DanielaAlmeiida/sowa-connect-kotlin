package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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
                brush = Brush.horizontalGradient(
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