package edu.ucne.parcial1_jhon.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_jhon.data.local.dao.ArticuloDao
import edu.ucne.parcial1_jhon.data.local.entity.Articulo


@Database(
    entities = [Articulo::class],
    version = 2,
    exportSchema = false
)


abstract class AppDataBase: RoomDatabase() {
    abstract val articuloDao: ArticuloDao
}


