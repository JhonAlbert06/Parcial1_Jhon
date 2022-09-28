package edu.ucne.parcial1_jhon.data.repository

import edu.ucne.parcial1_jhon.data.AppDataBase
import edu.ucne.parcial1_jhon.data.local.entity.Articulo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticuloRepository @Inject constructor(
    private val db: AppDataBase
) {

    suspend fun insert(articulo: Articulo){
        db.articuloDao.insert(articulo)
    }

    suspend fun delete(articulo: Articulo){
        db.articuloDao.delete(articulo)
    }

    suspend fun getById(id:Int): Articulo? {
        return db.articuloDao.getById(id)
    }

    fun getAll(): Flow<List<Articulo>> {
        return db.articuloDao.getAll()
    }
}