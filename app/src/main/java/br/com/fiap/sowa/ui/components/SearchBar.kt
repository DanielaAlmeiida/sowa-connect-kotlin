package br.com.fiap.sowa.ui.components

import androidx.compose.material3.TextField
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
            .height(50.dp)
            .background(colorResource(id = R.color.bluePrincipal)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(modifier = Modifier
            .weight(1f)
            .padding(horizontal = 4.dp),
            value = "a", onValueChange = {
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
            }
            )

        Button(
            onClick = { /* Sua ação ao clicar no botão */ },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp),
            content = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Texto ",
                        fontSize = 12.sp,
                        color = Color.Blue
                    )
                }
            }
        )


    }

}