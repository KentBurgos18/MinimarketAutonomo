package com.example.minimarketautonomo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minimarketautonomo.Inicio
import com.example.minimarketautonomo.Inicio.Companion.room
import com.example.minimarketautonomo.database.entidades.PagoEntity
import com.example.minimarketautonomo.navigation.AppScreens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EliminarPago(navController: NavController){

    LogoInicio()

    var ide = remember { mutableStateOf("") }
    var mostrarAviso = remember { mutableStateOf(false) } // Variable para mostrar el aviso
    val db = Inicio.room

    val scope = rememberCoroutineScope()


    Column(modifier = Modifier
        .padding(horizontal = 50.dp)
        .fillMaxSize(),
        //.background(Color.White),
        verticalArrangement = Arrangement.Center)


    {

        TextField(
            value = ide.value,
            onValueChange = { ide.value = it },
            label = { Text("ID", color = Color.Black) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.background(Color.White)
                .border(3.dp, Color.Black, RoundedCornerShape(5.dp)),
        )

        Button(
            onClick = {
                if ( ide.value.isBlank())
                {
                    mostrarAviso.value = true // Mostrar el aviso si algún campo está vacío

                }
                else
                {
                    var Id = ide.value.toInt()

                    scope.launch {
                        withContext(Dispatchers.Main) {
                            if (room.getPagoDao().getAllPagos().any { it.id == Id })
                            {
                                val pago = PagoEntity(
                                    id = Id,
                                    Valor = 0,
                                    Tipo = "",
                                    Cantidad = 0
                                )
                                db.getPagoDao().delete(pago)
                                val pagosGuardados = db.getPagoDao().getAllPagos()
                                navController.navigate(route = AppScreens.Home.route)
                                println(pagosGuardados)

                            }
                        }

                    }


                }

            },
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 77.dp)
        ) {
            Text("Eliminar pago")
        }


    }
    if (mostrarAviso.value === true) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("!!!") },
            text = { Text("LLENE TODOS LOS CAMPOS!") },
            confirmButton = {
                Button(
                    modifier = Modifier.background(Color.Gray),
                    onClick = { mostrarAviso.value = false
                    },
                ) {
                    Text("Ok")
                }
            },
            modifier = Modifier.background(Color.White)
        )
    }

}
