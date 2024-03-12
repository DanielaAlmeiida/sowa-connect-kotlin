package br.com.fiap.sowa.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(navController: NavController) {
    Header()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF2C4EC7))
        .padding(32.dp)
    ){
        Text(
            text = "Home",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Button(
                onClick = { /* navController.navigate("home") */},
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(text = "Home", fontSize = 20.sp, color = Color.Blue)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /*navController.navigate("connections")*/ },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(text = "Connections", fontSize = 20.sp, color = Color.Blue)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /*navController.navigate("perfil")*/ },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(text = "Perfil", fontSize = 20.sp, color = Color.Blue)
            }
        }
    }

    NavBar()
}