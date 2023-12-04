package com.example.minimarketautonomo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minimarketautonomo.screen.IniciarSesion

@Composable
fun AppNavegation() {
    val navController = rememberNavController()
    NavHost(navController =navController , startDestination = AppScreens.SplashScreen.route){
        composable(route = AppScreens.IniciarSesion.route){
            IniciarSesion(navController)
        }
    }

}