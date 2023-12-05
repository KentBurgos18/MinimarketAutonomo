package com.example.minimarketautonomo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.minimarketautonomo.database.entidades.QuejaEntity

@Dao
interface QuejaDao {
    @Query("SELECT * FROM queja_table" )
    suspend fun getAllQuejas():List<QuejaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(quejas: QuejaEntity)

    @Update
    suspend fun actualizar(quejas: QuejaEntity)

    @Delete
    suspend fun eliminar(quejas: QuejaEntity)

}