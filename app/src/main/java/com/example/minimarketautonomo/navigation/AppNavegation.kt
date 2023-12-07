package com.example.minimarketautonomo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minimarketautonomo.screen.Home
import com.example.minimarketautonomo.screen.IniciarSesion
import com.example.minimarketautonomo.screen.Pago
import com.example.minimarketautonomo.screen.Producto
import com.example.minimarketautonomo.screen.Registro
import com.example.minimarketautonomo.screen.SplashScreen

@Composable
fun AppNavegation() {
    val navController = rememberNavController()
    NavHost(navController =navController , startDestination = AppScreens.SplashScreen.route){
        composable(route = AppScreens.IniciarSesion.route){
            IniciarSesion(navController)
        }
        composable(route = AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(route = AppScreens.Registro.route){
            Registro(navController)
        }
        composable(route = AppScreens.Home.route){
            Home(navController)
        }
        composable(route = AppScreens.Producto.route){
            Producto(navController)
        }
        composable(route = AppScreens.Pago.route){
            Pago(navController)
        }

    }

}