package edu.ucne.parcial1_jhon.ui.articulo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jhon.data.local.entity.Articulo
import edu.ucne.parcial1_jhon.data.repository.ArticuloRepository
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditArticuloViewModel @Inject constructor(
    private val repository: ArticuloRepository
): ViewModel() {

    var descripcion by mutableStateOf("")
    var marca by mutableStateOf("")
    var existencia by mutableStateOf("")

    var currenId by mutableStateOf(0)

    init {
        viewModelScope.launch {
            var articulo = repository.getById(currenId)

            if (articulo != null) {
                descripcion = articulo.descripcion
                marca = articulo.marca
                existencia = articulo.existencia.toString()
            }
        }
    }

    fun save(articulo: Articulo){
        viewModelScope.launch {
            repository.insert(articulo)
        }
    }




}