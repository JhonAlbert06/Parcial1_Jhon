package edu.ucne.parcial1_jhon.data.local.dao

import androidx.room.*
import edu.ucne.parcial1_jhon.data.local.entity.Articulo
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticuloDao {
    @Insert
    suspend fun insert(articulo: Articulo)

    @Delete
    suspend fun delete(articulo: Articulo)

    @Query("select * from articulos")
    fun getAll(): Flow<List<Articulo>>

    @Query("select * from articulos where articuloId = :id")
    suspend fun getById(id:Int): Articulo?
}