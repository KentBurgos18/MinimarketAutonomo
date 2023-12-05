package com.example.minimarketautonomo.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "usuario_table")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "nombres") val Nombres: String,
    @ColumnInfo (name = "correo") val Correo: String,
    @ColumnInfo (name = "contraseña") val Contraseña: String,
){}

