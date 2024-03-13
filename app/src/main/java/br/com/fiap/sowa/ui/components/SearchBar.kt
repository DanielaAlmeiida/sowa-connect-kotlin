package br.com.fiap.sowa.ui.components

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.sowa.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(modifier = Modifier
                .padding(20.dp),
                value = "", onValueChange = {
            },
            label={
                Text(text = "Label aqui")
            },
            placeholder ={
                Text(text = "Placeholder aqui")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null
                )
            },
        )

        Button(
            onClick = { /* Sua ação ao clicar no botão */ },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier
                .weight(.2f),
            content = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_filter_alt_24),
                        contentDescription = null,
                        tint = colorResource(id = R.color.grayPrincipal),
                    )
                }
            }
        )

    }
}