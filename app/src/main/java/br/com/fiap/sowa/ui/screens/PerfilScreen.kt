package br.com.fiap.sowa.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar

@Composable
fun PerfilScreen( navController: NavController ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier .fillMaxSize()
    ) {
        Header()
        //Conteúdo profile
        NavBar(navController, "perfil")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPerfilScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        PerfilScreen(navController = navController)
    }
}