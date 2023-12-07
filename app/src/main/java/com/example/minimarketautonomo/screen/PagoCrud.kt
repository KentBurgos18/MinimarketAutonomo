package com.example.minimarketautonomo.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minimarketautonomo.navigation.AppScreens

@Composable
fun PagoCrud(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón 1: Ver pagos registrados
        Button(
            onClick = { navController.navigate(route = AppScreens.PagosRegistrados.route) },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ver pagos registrados")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón 2: Editar pago
        Button(
            onClick = { navController.navigate(route = AppScreens.EditarPago.route) },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Editar pago")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón 3: Eliminar pago
        Button(
            onClick = { navController.navigate(route = AppScreens.EliminarPago.route) },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Eliminar pago")
        }
    }

}