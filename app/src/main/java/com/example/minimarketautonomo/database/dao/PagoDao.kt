package com.example.minimarketautonomo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.minimarketautonomo.database.entidades.PagoEntity

@Dao
interface PagoDao {

    @Query("SELECT * FROM pago_table")
    suspend fun getAllPagos(): List<PagoEntity>

    @Query("SELECT * FROM pago_table WHERE id = :id")
    fun getPagoById(id: Int): PagoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pago: PagoEntity)

    @Update
    suspend fun update(pago: PagoEntity)

    @Delete
    suspend fun delete(pago: PagoEntity)


}
