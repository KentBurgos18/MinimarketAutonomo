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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minimarketautonomo.Inicio.Companion.room
import com.example.minimarketautonomo.database.entidades.UsuarioEntity
import com.example.minimarketautonomo.navigation.AppScreens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registro(navController: NavController) {

    LogoInicio()
    // Variables para almacenar los valores de los campos del formulario
    var nombres = remember { mutableStateOf("") }
    var correo = remember { mutableStateOf("") }
    var contraseña = remember { mutableStateOf("") }
    var mostrarAviso = remember { mutableStateOf(false) } // Variable para mostrar el aviso
    val db = room

    val scope = rememberCoroutineScope()


    Column(modifier = Modifier
        .padding(horizontal = 50.dp)
        .fillMaxSize(),
        //.background(Color.White),
        verticalArrangement = Arrangement.Center)


    {
        // Campo de nombres
        TextField(
            value = nombres.value,
            onValueChange = { nombres.value = it },
            label = { Text("Nombres", color = Color.Black) },
            modifier = Modifier.background(Color.White)
                .border(3.dp, Color.Black, RoundedCornerShape(5.dp)),
            //.fillMaxSize()
        )

        // Campo de correo
        TextField(
            value = correo.value,
            onValueChange = { correo.value = it },
            label = { Text("Correo", color = Color.Black) },
            modifier = Modifier.background(Color.White)
                .border(3.dp, Color.Black, RoundedCornerShape(5.dp)),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        // Campo de contraseña
        TextField(
            value = contraseña.value,
            onValueChange = { contraseña.value = it },
            label = { Text("Contraseña", color = Color.Black) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.background(Color.White)
                .border(3.dp, Color.Black, RoundedCornerShape(5.dp)),
        )



        // Botón de registro
        Button(
            onClick = {
                //navController.navigate(route = AppScreens.IniciarSesion.route)
                //Ajustes()
                if (nombres.value.isBlank() || correo.value.isBlank() || contraseña.value.isBlank() )

                {
                    mostrarAviso.value = true // Mostrar el aviso si algún campo está vacío

                }
                else
                {
                    val usuario = UsuarioEntity(
                        Nombres = nombres.value,
                        Correo = correo.value,
                        Contraseña = contraseña.value
                    )
                    scope.launch {
                        withContext(Dispatchers.Main) {
                            db.getUsuarioDao().insert(usuario)
                            val usuariosGuardados = db.getUsuarioDao().getAllUsuarios()
                            navController.navigate(route = AppScreens.IniciarSesion.route)
                            println(usuariosGuardados)
                        }
                    }

                }

            },
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 77.dp)
        ) {
            Text("Registrarse")
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

