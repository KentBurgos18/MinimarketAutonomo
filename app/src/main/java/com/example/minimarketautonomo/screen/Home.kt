package com.example.minimarketautonomo.screen

import android.media.tv.TvContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.minimarketautonomo.R
import com.example.minimarketautonomo.navigation.AppScreens
import com.example.minimarketautonomo.ui.theme.Fondo


@Composable
fun Home(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.End) {
            Button(
                onClick = {
                    navController.navigate(route = AppScreens.Queja.route)
                },
                modifier = Modifier.padding(vertical = 0.dp, horizontal = 0.dp)
            ) {
                Text("QUEJAS")
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.End) {
            Button(
                onClick = {
                    navController.navigate(route = AppScreens.PagoCrud.route)
                },
                modifier = Modifier.padding(vertical = 0.dp, horizontal = 0.dp)
            ) {
                Text(" PAGOS ")
            }


        }
    }
    LogoInicio()
    Texto()
    Opciones(navController)


}



@Composable
fun Texto(){
    Text(text = "Bienvenido a tu supermercado de confianza!",
        textAlign = TextAlign.Center,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
        fontSize = 21.sp,
        modifier = Modifier.padding(horizontal = 50.dp,vertical = 190.dp))



}
@Composable
fun Opciones(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(480.dp)
                .padding(vertical = 0.dp, horizontal = 50.dp)
        ) {
            Card(
                modifier = Modifier.clickable{
                    navController.navigate(route = AppScreens.Producto.route)
                }
            ) {
                Text(text = "PRODUCTOS",
                    fontSize = 33.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 0.dp,vertical = 0.dp)
                )
                Image(
                    painter = painterResource(R.drawable.productos_icon),
                    contentDescription = "productos"
                )
            }
        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp, horizontal = 50.dp)
        ) {
            Card(
                modifier = Modifier.clickable{
                    navController.navigate(route = AppScreens.Pedido.route)
                }
            ) {
                Text(text = "PEDIDOS",
                    fontSize = 33.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 0.dp,vertical = 0.dp)
                )
                Image(
                    painter = painterResource(R.drawable.pedidos_icon),
                    contentDescription = "pedidos"
                )
            }
        }
    }
}

/*
@Composable
@Preview
fun OpcionesPreview() {
    Opciones()
}*/