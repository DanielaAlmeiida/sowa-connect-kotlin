package br.com.fiap.sowa.ui.screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.components.EnderecoCadastro
import br.com.fiap.sowa.ui.components.EscolaOrProfissional
import br.com.fiap.sowa.ui.components.GradientHeaderWithImage
import br.com.fiap.sowa.ui.components.LoginAndCadastro

@Composable
fun CadastroScreen(navController: NavController) {

    Column(
    ) {
        GradientHeaderWithImage()
        LoginAndCadastro(navController)
        EscolaOrProfissional(navController)
        EnderecoCadastro(navController)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCadastroScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        CadastroScreen(navController = navController)
    }
}