package com.example.minimarketautonomo

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class Preferencias(val context: Context) {

    val SHARED_NAME = "PagoValor"
    val SHARED_NAME2 = "PagoContador"
    val SHARED_NAME3 = "Id"
    val SHARED_NAME4 = "Calificanos"



    val SHARED_VALOR = "Valor"
    val SHARED_CONTADOR = "ContadorProductos"
    val SHARED_ID = "IdPago"
    val SHARED_RATE = "Calificacion app"




    val storage = context.getSharedPreferences(SHARED_NAME, 0)
    val storage2 = context.getSharedPreferences(SHARED_NAME2, 0)
    val storage3 = context.getSharedPreferences(SHARED_NAME3, 0)
    val storage4 = context.getSharedPreferences(SHARED_NAME4, 0)




    fun saveValor(valor: Int){
        storage.edit().putInt(SHARED_VALOR, valor).apply()
    }

    fun getValor(): Int {
        return storage.getInt(SHARED_VALOR, 0)!!
    }

    fun saveContador(valor: Int){
        storage2.edit().putInt(SHARED_VALOR, valor).apply()
    }

    fun getContador(): Int {
        return storage2.getInt(SHARED_VALOR, 0)!!
    }

    fun saveIde(valor: Int){
        storage3.edit().putInt(SHARED_ID, valor).apply()
    }

    fun getIde(): Int {
        return storage3.getInt(SHARED_ID, 0)!!
    }

    fun saveRate(rate: Int){
        storage4.edit().putInt(SHARED_RATE, rate).apply()

    }

    fun getRate(): Int {
        return storage4.getInt(SHARED_RATE, 0)!!
    }


}