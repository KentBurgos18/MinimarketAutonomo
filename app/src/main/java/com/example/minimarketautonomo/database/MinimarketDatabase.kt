package com.example.minimarketautonomo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.minimarketautonomo.database.dao.MetodoDePagoDao
import com.example.minimarketautonomo.database.dao.PedidoDao
import com.example.minimarketautonomo.database.dao.QuejaDao
import com.example.minimarketautonomo.database.dao.UsuarioDao
import com.example.minimarketautonomo.database.entidades.MetodoDePagoEntity
import com.example.minimarketautonomo.database.entidades.PedidoEntity
import com.example.minimarketautonomo.database.entidades.QuejaEntity
import com.example.minimarketautonomo.database.entidades.UsuarioEntity

@Database(entities= [UsuarioEntity::class, MetodoDePagoEntity::class, QuejaEntity::class, PedidoEntity::class], version = 1)
abstract class MinimarketDatabase: RoomDatabase() {
    abstract fun getUsuarioDao(): UsuarioDao
    abstract fun getMetodoDePagoDao(): MetodoDePagoDao
    abstract fun getQuejaDao():QuejaDao
    abstract fun getPedidoDao():PedidoDao

}