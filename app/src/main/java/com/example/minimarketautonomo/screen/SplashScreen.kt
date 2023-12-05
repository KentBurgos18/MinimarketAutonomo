package com.example.minimarketautonomo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minimarketautonomo.R
import com.example.minimarketautonomo.navigation.AppScreens
import com.example.minimarketautonomo.ui.theme.Fondo
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true){
        delay(5000)
        navController.popBackStack()
        navController.navigate(route = AppScreens.IniciarSesion.route)
    }
    Splash()

}

@Composable
fun Splash(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Fondo),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Mascota",
            modifier = Modifier
                .size(110.dp)
                .clip(shape = CircleShape))
        Text(text = "BIENVENIDO!")

    }


}
