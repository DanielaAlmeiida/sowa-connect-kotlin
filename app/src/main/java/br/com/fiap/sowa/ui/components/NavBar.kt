package br.com.fiap.sowa.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import br.com.fiap.sowa.R

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavBar(navController: NavController, perfilButton: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(colorResource(id = R.color.bluePrincipal)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(if (perfilButton == "home") Color.Blue else colorResource(id = R.color.bluePrincipal)),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                //.padding(horizontal = 4.dp) // Ajuste o espaçamento entre os botões conforme necessário
        ) {
            Text(text = "Home", fontSize = 12.sp, color = Color.White)
        }

        Button(
            onClick = { navController.navigate("connections") },
            colors = ButtonDefaults.buttonColors(if (perfilButton == "connections") Color.Blue else colorResource(id = R.color.bluePrincipal)),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                //.padding(horizontal = 4.dp) // Ajuste o espaçamento entre os botões conforme necessário
        ) {
            Text(text = "Connections", fontSize = 12.sp, color = Color.White)
        }

        Button(
            onClick = { navController.navigate("perfil") },
            colors = ButtonDefaults.buttonColors(if (perfilButton == "perfil") Color.Blue else colorResource(id = R.color.bluePrincipal)),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                //.padding(horizontal = 4.dp) // Ajuste o espaçamento entre os botões conforme necessário
        ) {
            Text(text = "Perfil", fontSize = 12.sp, color = Color.White)
        }
    }
}


