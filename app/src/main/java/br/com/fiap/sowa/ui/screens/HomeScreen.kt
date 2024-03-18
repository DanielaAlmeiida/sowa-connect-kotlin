package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.CardPersonSearch
import br.com.fiap.sowa.ui.components.SearchBar

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.superLightBlue))

    ) {
        Header()
        SearchBar()
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                CardPersonSearch("Carlos Eduardo", "Física, Matemática", "SP", avaliacao = "4.5")
                CardPersonSearch("David Bush", "História, Geografia", "BA", avaliacao = "4.2")
                CardPersonSearch("Daniela Alameda", "Artes, Teatro", "RJ", avaliacao = "4.8")
                CardPersonSearch("Thamirys Iris", "Artes Marciais, Dança", "CE", avaliacao = "4.6")
                CardPersonSearch("João Vittor", "Espanhol, Inglês", "TO", avaliacao = "4.7")
                CardPersonSearch("João Vittor", "Espanhol, Inglês", "TO", avaliacao = "4.7")
                CardPersonSearch("João Vittor", "Espanhol, Inglês", "TO", avaliacao = "4.7")
            }
        }
        NavBar(navController,  "home")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        HomeScreen(navController = navController)
    }
}