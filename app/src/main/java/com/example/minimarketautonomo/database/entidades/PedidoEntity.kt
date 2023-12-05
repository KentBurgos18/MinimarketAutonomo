package com.example.minimarketautonomo.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pedido_table",
    foreignKeys = [
        ForeignKey(entity = PagoEntity::class, parentColumns = ["id"], childColumns = ["pago_Id"])
    ]
)
data class PedidoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "fecha") val Fecha: String,
    @ColumnInfo(name = "descripcion") val Descripcion: String,
    @ColumnInfo(name = "pago_Id") val Pago_Id: Int,
){}