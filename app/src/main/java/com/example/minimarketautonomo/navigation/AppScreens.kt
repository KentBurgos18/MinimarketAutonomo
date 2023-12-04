package com.example.minimarketautonomo.navigation

sealed class AppScreens(val route: String){
    object IniciarSesion: AppScreens("iniciarSesion")
    object SplashScreen: AppScreens("splashScreen")

}