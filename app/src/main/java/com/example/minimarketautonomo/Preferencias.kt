package com.example.minimarketautonomo

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class Preferencias(val context: Context) {

    val SHARED_NAME = "PagoValor"
    val SHARED_NAME2 = "PagoContador"

    val SHARED_VALOR = "Valor"
    val SHARED_CONTADOR = "ContadorProductos"




    val storage = context.getSharedPreferences(SHARED_NAME, 0)
    val storage2 = context.getSharedPreferences(SHARED_NAME2, 0)



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


}