package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R

@Composable
fun PerfilDados(telefone: String, email: String, endereco: String, descricao: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(20.dp)
    ) {
        Row {
            Text(
                text = "Telefone:",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = telefone,
                fontSize = 13.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            Text(
                text = "Email:",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = email,
                fontSize = 13.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            Text(
                text = "Endereço:",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = endereco,
                fontSize = 13.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
        }
        LazyColumn (
            modifier = Modifier.weight(1f)
        ) {
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 12.dp, 0.dp, 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = colorResource(id = R.color.lightGray2)
                )  {
                    Text(
                        text = descricao,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black,
                        modifier = Modifier .padding(14.dp)
                    )
                }
            }
        }
        Column {
            Text(
                text = "Áreas de interesse:",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
            )
            Row {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height(30.dp)
                        .padding(0.dp, 0.dp, 5.dp, 0.dp)

                ) {
                    Text(text = "#Teatro", fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Medium)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height(30.dp)
                        .padding(0.dp, 0.dp, 5.dp, 0.dp)
                ) {
                    Text(text = "#Dança", fontSize = 10.sp, color = Color.White,fontWeight = FontWeight.Medium)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height(30.dp)
                        .padding(0.dp, 0.dp, 5.dp, 0.dp)
                ) {
                    Text(text = "#Robotica", fontSize = 10.sp, color = Color.White,fontWeight = FontWeight.Medium)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height(30.dp)
                        .padding(0.dp, 0.dp, 5.dp, 0.dp)
                ) {
                    Text(text = "#Ciencia", fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}