package com.example.minimarketautonomo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minimarketautonomo.screen.EditarPago
import com.example.minimarketautonomo.screen.EliminarPago
import com.example.minimarketautonomo.screen.EliminarPedido
import com.example.minimarketautonomo.screen.Home
import com.example.minimarketautonomo.screen.IniciarSesion
import com.example.minimarketautonomo.screen.Pago
import com.example.minimarketautonomo.screen.PagoCrud
import com.example.minimarketautonomo.screen.PagosRegistrados
import com.example.minimarketautonomo.screen.Pedido
import com.example.minimarketautonomo.screen.PedidoCrud
import com.example.minimarketautonomo.screen.PedidosRegistrados
import com.example.minimarketautonomo.screen.Producto
import com.example.minimarketautonomo.screen.Queja
import com.example.minimarketautonomo.screen.Registro
import com.example.minimarketautonomo.screen.SplashScreen
import com.example.minimarketautonomo.screen.VistaQuejas

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
        composable(route = AppScreens.PagoCrud.route){
            PagoCrud(navController)
        }
        composable(route = AppScreens.PagosRegistrados.route){
            PagosRegistrados(navController)
        }
        composable(route = AppScreens.EditarPago.route){
            EditarPago(navController)
        }
        composable(route = AppScreens.EliminarPago.route){
            EliminarPago(navController)
        }
        composable(route = AppScreens.Pedido.route){
            Pedido(navController)
        }
        composable(route = AppScreens.EliminarPedido.route){
            EliminarPedido(navController)
        }
        composable(route = AppScreens.PedidoCrud.route){
            PedidoCrud(navController)
        }
        composable(route = AppScreens.PedidosRegistrados.route){
            PedidosRegistrados(navController)
        }
        composable(route = AppScreens.Queja.route){
            Queja(navController)
        }
        composable(route = AppScreens.VistaQuejas.route){
            VistaQuejas(navController)
        }



    }

}