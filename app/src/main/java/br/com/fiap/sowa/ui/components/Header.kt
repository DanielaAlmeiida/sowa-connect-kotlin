package br.com.fiap.sowa.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Header() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(colorResource(id = R.color.bluePrincipal)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Logo do SOWA Connection"
        )

        Text(
            text = "SOWA Connect",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )


        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Ícone notificações"
            )
            Text(text = "9+", fontSize = 20.sp, color = Color.White)
        }


    }
}