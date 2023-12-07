package com.example.minimarketautonomo.navigation

sealed class AppScreens(val route: String){
    object IniciarSesion: AppScreens("iniciarSesion")
    object SplashScreen: AppScreens("splashScreen")
    object Registro: AppScreens("registro")
    object Home: AppScreens("home")
    object Producto: AppScreens("producto")
    object Pedido: AppScreens("pedido")
    object Queja: AppScreens("quejas")
    object Pago: AppScreens("pago")
    object PagoCrud: AppScreens("pagoCrud")
    object PagosRegistrados: AppScreens("pagosRegistrados")
    object EditarPago: AppScreens("editarPago")
    object EliminarPago: AppScreens("eliminarPago")
    object PedidoCrud: AppScreens("pedidoCrud")
    object PedidosRegistrados: AppScreens("pedidosRegistrados")
    object EliminarPedido: AppScreens("eliminarPedido")









}