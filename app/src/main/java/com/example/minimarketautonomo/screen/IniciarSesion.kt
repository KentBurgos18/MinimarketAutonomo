package com.example.minimarketautonomo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minimarketautonomo.Inicio.Companion.room
import com.example.minimarketautonomo.R
import com.example.minimarketautonomo.navigation.AppScreens
import kotlinx.coroutines.launch

@Composable
fun IniciarSesion(navController: NavController){
    Row(modifier = Modifier
        .fillMaxWidth(
        ), horizontalArrangement = Arrangement.End) {
        Button(
            onClick = {
                //navController.navigate(route = AppScreens.Ajustes.route)
            },
            modifier = Modifier.padding(vertical = 0.dp, horizontal = 0.dp)
        ) {
            Text("AJUSTES")
        }
    }
    Text(text = "MINIMARKET", modifier = Modifier
        .padding(horizontal = 137.dp),
        fontSize = 19.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    LogoInicio()
    Text(text = "¡TU SUPERMERCADO EN LA PALMA DE TU MANO! DESCUBRE Y ELIGE CON NUESTRA APP",
        modifier = Modifier
            .padding(vertical = 165.dp, horizontal = 39.dp),
        fontSize = 18.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    FormularioInicioSesion(navController)

}


@Composable
fun LogoInicio(){

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Mascota",
            modifier = Modifier
                .padding(35.dp)
                .size(110.dp)
                .clip(shape = CircleShape)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioInicioSesion(navController: NavController){
    var correo = remember { mutableStateOf("") }
    var contraseña = remember { mutableStateOf("") }
    var mostrarAviso2 = remember { mutableStateOf(false) } // Variable para mostrar el aviso

    val scope = rememberCoroutineScope()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
        ,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Correo", fontSize = 20.sp)
        TextField(value = correo.value, onValueChange = { correo.value = it },
            modifier = Modifier
                .padding(vertical = 8.dp))
        Text(text = "Contraseña", fontSize = 20.sp)
        TextField(value = contraseña.value, onValueChange = { contraseña.value = it },
            modifier = Modifier
                .padding(vertical = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Row() {
            Button(
                onClick = {
                    //if (usuario.value == preferencias.getCorreo() && contraseña.value == preferencias.getContraseña() )
                    scope.launch {
                        if (room.getUsuarioDao().getAllUsuarios().any { it.Correo == correo.value })
                        {
                            navController.popBackStack()
                            navController.navigate(route = AppScreens.Home.route)
                        }
                        else
                        {
                            mostrarAviso2.value = true
                        }
                    }


                },
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 5.dp)
            ) {
                Text("Iniciar sesion")
            }
            Button(
                onClick = {
                    navController.navigate(route = AppScreens.Registro.route)
                },
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 5.dp)
            ) {
                Text("Registrarse")
            }
        }
    }
    if (mostrarAviso2.value === true) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("Autenticacion fallada") },
            text = { Text("DATOS INCORRECTOS!") },
            confirmButton = {
                Button(
                    modifier = Modifier.background(Color.Gray),
                    onClick = {
                        mostrarAviso2.value = false
                    },
                ) {
                    Text("Ok")
                }
            },
            modifier = Modifier.background(Color.White)
        )
    }
}