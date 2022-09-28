package edu.ucne.parcial1_jhon.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Articulos")
data class Articulo(
    @PrimaryKey(autoGenerate = true)
    val articuloId: Int? = null,
    val descripcion: String = "",
    val marca: String = "",
    val existencia: Double = 0.0
)
