package com.example.minimarketautonomo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.minimarketautonomo.database.entidades.UsuarioEntity

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuario_table" )
    suspend fun getAllUsuarios():List<UsuarioEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuarios:UsuarioEntity)
}