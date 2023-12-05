package com.example.minimarketautonomo.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pago_table")
data class PagoEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "valor") val Valor: Int,
    @ColumnInfo(name = "tipo") val Tipo: String
){}