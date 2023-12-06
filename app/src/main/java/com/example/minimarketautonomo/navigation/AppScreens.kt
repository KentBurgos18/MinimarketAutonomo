package com.example.minimarketautonomo.navigation

sealed class AppScreens(val route: String){
    object IniciarSesion: AppScreens("iniciarSesion")
    object SplashScreen: AppScreens("splashScreen")
    object Registro: AppScreens("registro")
    object Home: AppScreens("home")
    object Producto: AppScreens("producto")
    object Pedido: AppScreens("pedido")
    object Queja: AppScreens("quejas")




}