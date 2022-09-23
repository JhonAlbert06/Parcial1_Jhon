package edu.ucne.parcial1_jhon.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Auxs")
data class Aux(
    @PrimaryKey(autoGenerate = true)
    val auxId: Int? = null,
    val aux1: String = "",
    val aux2: String = "",
    val aux3: Double = 0.0
)
