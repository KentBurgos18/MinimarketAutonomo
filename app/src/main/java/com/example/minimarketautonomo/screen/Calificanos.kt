package com.example.minimarketautonomo.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minimarketautonomo.Inicio.Companion.preferencias
import com.example.minimarketautonomo.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calificanos(navController: NavController) {

    var rating = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        // Calificación con estrellas
        Text(text = "CALIFICA NUESTRA APLICACIÓN", fontSize = 20.sp)
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            repeat(5) { index ->
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = if (index < rating.value) Color.Yellow else Color.Gray,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { rating.value = index + 1 }
                )
            }
        }
        Button(
            onClick = {
                preferencias.saveRate(rating.value)
                navController.popBackStack()
                navController.navigate(route = AppScreens.IniciarSesion.route)
            },
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 5.dp)
        ) {
            Text("ENVIAR CALIFICACION")
        }
        Text("GRACIAS POR TUS ${preferencias.getRate()} ESTRELLAS", style = MaterialTheme.typography.titleMedium)

    }
}