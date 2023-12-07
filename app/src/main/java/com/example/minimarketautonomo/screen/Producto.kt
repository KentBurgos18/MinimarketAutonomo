package com.example.minimarketautonomo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minimarketautonomo.Inicio.Companion.preferencias
import com.example.minimarketautonomo.R
import com.example.minimarketautonomo.navigation.AppScreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun Producto(navController: NavController){

    Texto2()
    Seleccion()
    DetallesDePago(navController)


}

@Composable
fun Texto2(){
    Text(text = "PRODUCTOS",
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 10.dp)
            .fillMaxWidth()
    )
    Text(text = "LLENE SU CARRITO CON NUESTROS PRODUCTOS :)",
        textAlign = TextAlign.Center,
        fontSize = 13.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black,
        modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Seleccion(){

    var contador = preferencias.getContador()
    var valor = preferencias.getValor()

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(vertical = 0.dp, horizontal = 0.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto1),
                    contentDescription = "producto1",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto2),
                    contentDescription = "producto2",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto3),
                    contentDescription = "producto3",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 0.dp, horizontal = 0.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto4),
                    contentDescription = "producto4",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto5),
                    contentDescription = "producto5",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto6),
                    contentDescription = "producto6",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 0.dp, horizontal = 0.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto7),
                    contentDescription = "producto7",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto8),
                    contentDescription = "producto8",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto9),
                    contentDescription = "producto9",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 0.dp, horizontal = 0.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto10),
                    contentDescription = "producto10",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto11),
                    contentDescription = "producto11",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.producto12),
                    contentDescription = "producto12",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .clickable {
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                            contador = preferencias.getContador()
                            valor = preferencias.getValor()
                            contador++
                            // Ejecuta la tarea de incrementar el contador en paralelo
                            val task1 = GlobalScope.launch {
                                preferencias.saveContador(contador)
                            }
                            println(preferencias.getValor())
                            valor += 2
                            // Ejecuta la tarea de guardar el valor de la preferencia `valor` en paralelo
                            val task2 = GlobalScope.launch {
                                preferencias.saveValor(valor)
                            }
                            // Espera a que ambas tareas terminen
                            CoroutineScope(Dispatchers.Main).launch {
                                task1.join()
                                task2.join()
                            }
                            println(preferencias.getContador())
                            println(preferencias.getValor())
                        }
                )
            }
        }
    }

}

@Composable
fun DetallesDePago(navController:NavController){
    var contador = remember { mutableStateOf(preferencias.getContador()) }
    var valor = remember { mutableStateOf(preferencias.getValor()) }

    LaunchedEffect(true) {
        while(true){
            contador.value = preferencias.getContador()
            valor.value = preferencias.getValor()

            delay(500)

        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom
        ) {
            Column(modifier = Modifier.weight(10f)) {
                Text(
                    text = "Tu compra tiene ${contador.value} productos y " +
                            "tiene un valor de ${valor.value}",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 21.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 0.dp)
                )
            }
            Column(modifier = Modifier.weight(4.5f)
                .height(120.dp)) {
                Button(
                    onClick = { navController.navigate(route = AppScreens.Pago.route) },
                ) {
                    Text("VER PAGO")
                }
                Button(
                    onClick = {
                        preferencias.saveContador(0)
                        preferencias.saveValor(0)
                    }
                ) {
                    Text("REINICIAR CARRITO")
                }
            }

        }
    }
}