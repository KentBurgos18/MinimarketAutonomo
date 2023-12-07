package com.example.minimarketautonomo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.example.minimarketautonomo.Inicio.Companion.room
import com.example.minimarketautonomo.database.entidades.QuejaEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VistaQuejas(navController: NavController) {
    val quejas = remember { mutableStateListOf<QuejaEntity>() }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val loadedQuejas = room.getQuejaDao().getAllQuejas()
            quejas.addAll(loadedQuejas)
        }
    }

    if (quejas.isNotEmpty()) {
        Column {
            quejas.forEach { queja ->
                QuejaItem(queja)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    } else {
        Text(text = "No hay quejas disponibles")
    }
}

@Composable
fun QuejaItem(queja: QuejaEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
            .zIndex(4f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "ID: ${queja.id}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Asunto: ${queja.Asunto}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Descripción: ${queja.Descripcion}")
        }
    }
}
