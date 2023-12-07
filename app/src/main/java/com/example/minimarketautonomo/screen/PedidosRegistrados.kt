package com.example.minimarketautonomo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.minimarketautonomo.Inicio
import com.example.minimarketautonomo.database.entidades.PedidoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun PedidosRegistrados(navController: NavController){

    val pedidos = remember { mutableStateListOf<PedidoEntity>() }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val loadedPedidos = Inicio.room.getPedidoDao().getAllPedidos()
            pedidos.addAll(loadedPedidos)
        }
    }

    if (pedidos.isNotEmpty()) {
        Column {
            Card(modifier = Modifier
                .fillMaxWidth()) {
                Row(modifier = Modifier.background(color = Color.Transparent)
                    .padding(horizontal = 20.dp)) {
                    Text(text = "Registro de pedidos")

                }

            }
            pedidos.forEach { pedido ->
                PedidoData(navController, pedido)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    } else {
        Text(text = "No hay pedidos")
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidoData(navController: NavController, pedido: PedidoEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(20.dp)
            .zIndex(4f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(Modifier.padding(20.dp)) {
            Text(text = "ID: ${pedido.id}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Fecha: ${pedido.Fecha}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Descripcion: ${pedido.Descripcion}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Pago: ${pedido.Pago_Id}")
        }
    }




}
