package edu.ucne.parcial1_jhon.ui.articulo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jhon.data.local.entity.Articulo
import edu.ucne.parcial1_jhon.data.repository.ArticuloRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditArticuloViewModel @Inject constructor(
    private val repository: ArticuloRepository
): ViewModel() {

    var descripcion: String = ""
    var marca: String = ""
    var existencia: String = ""

    fun save(articulo: Articulo){
        viewModelScope.launch {
            repository.insert(articulo)
        }
    }


}