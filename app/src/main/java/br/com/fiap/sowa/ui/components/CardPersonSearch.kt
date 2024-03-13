package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Ícone de pessoa
            Icon(
                painter = painterResource(id = R.drawable.baseline_filter_alt_24),
                contentDescription = "Ícone de pessoa",
                tint = Color.Gray,
                modifier = Modifier.size(48.dp)
            )

            // Espaçamento entre o ícone e as informações
            Spacer(modifier = Modifier.width(16.dp))

            // Informações do perfil (nome, áreas, localização)
            Column {
                Text(
                    text = "Nome da pessoa",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Áreas: Física, Matemática",
                    fontSize = 14.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "SP",
                        fontSize = 14.sp
                    )
                }
            }

            // Espaçamento entre as informações e a avaliação
            Spacer(modifier = Modifier.width(16.dp))

            // Avaliação e botão de ver perfil
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(1f)
            ) {
                // Avaliação
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_star_24),
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "4.5",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Espaçamento entre a avaliação e o botão
                Spacer(modifier = Modifier.height(8.dp))

                // Botão "Ver Perfil"
                Button(
                    onClick = { /* Ação ao clicar no botão */ },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.bluePrincipal)), // Define a cor de fundo do botão
                    modifier = Modifier
                        .align(Alignment.End)
                        .width(100.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "Ver Perfil",
                        color = Color.White,
                        fontSize = 9.sp,
                    )
                }

            }
        }
    }
}
