package com.example.minimarketautonomo.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "queja_table")
data class QuejaEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "asunto") val Asunto: String,
    @ColumnInfo(name = "descripcion") val Descripcion: String,
){}