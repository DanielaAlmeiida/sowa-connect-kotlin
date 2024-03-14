package br.com.fiap.sowa.ui.screens

/*import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.ProfileCard
import br.com.fiap.sowa.ui.components.SearchBar

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        SearchBar()
        ProfileCard("Carlos Eduardo", "Fisíca, Matemática", "SP", avaliacao = "4.5")
        ProfileCard("David Bush", "Historia, Geografia", "BA", avaliacao = "4.2")
        ProfileCard("João Vittor", "Artes, Teatro", "RJ", avaliacao = "4.8")
        NavBar(navController, perfilButton = "home")
    }
}*/

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.ProfileCard
import br.com.fiap.sowa.ui.components.SearchBar

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        SearchBar()
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                ProfileCard("Carlos Eduardo", "Física, Matemática", "SP", avaliacao = "4.5")
                ProfileCard("David Bush", "História, Geografia", "BA", avaliacao = "4.2")
                ProfileCard("Daniela Alameda", "Artes, Teatro", "RJ", avaliacao = "4.8")
                ProfileCard("Thamirys Iris", "Artes Marciais, Dança", "CE", avaliacao = "4.6")
                ProfileCard("João Vittor", "Espanhol, Inglês", "TO", avaliacao = "4.7")
                ProfileCard("João Vittor", "Espanhol, Inglês", "TO", avaliacao = "4.7")
                ProfileCard("João Vittor", "Espanhol, Inglês", "TO", avaliacao = "4.7")
            }
        }
        NavBar(navController, perfilButton = "home")
    }
}