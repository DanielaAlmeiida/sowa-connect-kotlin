package br.com.fiap.sowa.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.ProfileCard
import br.com.fiap.sowa.ui.components.ProfileCardConnection
import br.com.fiap.sowa.ui.components.SearchBar

@Composable
fun ConnectionsScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        SearchBar()
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                ProfileCardConnection("Carlos Eduardo", "Física, Matemática", "SP", "carlos@email.com", "(11) 96371-4893")
                ProfileCardConnection("David Bush", "História, Geografia", "BA", "carlos@email.com", "(11) 96371-4893")
                ProfileCardConnection("Daniela Alameda", "Artes, Teatro", "RJ", "carlos@email.com", "(11) 96371-4893")
                ProfileCardConnection("Thamirys Iris", "Artes Marciais, Dança", "CE", "carlos@email.com", "(11) 96371-4893")
                ProfileCardConnection("João Vittor", "Espanhol, Inglês", "TO", "carlos@email.com", "(11) 96371-4893")
                ProfileCardConnection("João Vittor", "Espanhol, Inglês", "TO", "carlos@email.com", "(11) 96371-4893")
                ProfileCardConnection("João Vittor", "Espanhol, Inglês", "TO", "carlos@email.com", "(11) 96371-4893")
            }
        }
        NavBar(navController, "connections")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewConnectionsScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        ConnectionsScreen(navController = navController)
    }
}