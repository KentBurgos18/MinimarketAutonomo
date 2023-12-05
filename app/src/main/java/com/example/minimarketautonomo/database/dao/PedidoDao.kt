package com.example.minimarketautonomo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.minimarketautonomo.database.entidades.PedidoEntity

@Dao
interface PedidoDao {

    @Query("SELECT * FROM pedido_table")
    suspend fun getAllPedidos(): List<PedidoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pedidos: PedidoEntity)

    @Update
    suspend fun update(pedidos: PedidoEntity)

    @Delete
    suspend fun delete(pedidos: PedidoEntity)
}
