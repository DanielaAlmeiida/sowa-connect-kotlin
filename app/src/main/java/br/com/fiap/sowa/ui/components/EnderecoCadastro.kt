package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.service.RetrofitFactory
import br.com.fiap.sowa.ui.screens.CadastroScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun EnderecoCadastro(navController: NavController) {
    var cep by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf(Endereco("", "", "", "", "")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 64.dp)
    ){
        OutlinedTextField(
            value = cep,
            onValueChange = { cep = it },
            label = { Text("CEP") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                searchCep(cep) { enderecoResult ->
                    endereco = enderecoResult ?: Endereco("","","","","") // Se o resultado for nulo, cria um endereço vazio
                }
            }),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { searchCep(cep) { enderecoResult ->
                endereco = enderecoResult ?: Endereco("", "", "", "", "")
            }
                },
            enabled = cep.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
            ) {
                Text("Buscar Endereço")
            }
        Spacer(modifier = Modifier.height(8.dp))

        // Campos do formulário de endereço
        OutlinedTextField(
            value = endereco.logradouro?: "",
            onValueChange = { endereco.logradouro = it },
            label = { Text("Logradouro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.bairro ?: "",
            onValueChange = { endereco.bairro = it },
            label = { Text("Bairro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.localidade ?: "",
            onValueChange = { endereco.localidade = it },
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.uf ?: "",
            onValueChange = { endereco.uf = it },
            label = { Text("UF") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
private fun searchCep(cep: String, onResult: (Endereco?) -> Unit) {
    val call = RetrofitFactory().getCepService().getEnderecoByCep(cep = cep)
    call.enqueue(object: Callback<Endereco> {
        override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
            if (response.isSuccessful) {
                val endereco = response.body()
                onResult(endereco)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<Endereco>, t: Throwable) {
            onResult(null)
        }
    })
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCadastroScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        EnderecoCadastro(navController = navController)
    }
}
