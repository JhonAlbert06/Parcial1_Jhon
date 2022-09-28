package edu.ucne.parcial1_jhon.ui.aux

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jhon.data.local.entity.Articulo
import edu.ucne.parcial1_jhon.data.repository.ArticuloRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuxListUiState(
    val articulos : List<Articulo> = emptyList()
)

@HiltViewModel
class HomeArticuloViewModel @Inject constructor(
    private val repository: ArticuloRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(AuxListUiState())
    val uiState : StateFlow<AuxListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy(articulos = list)
                }
            }
        }
    }

    fun delete(articulo: Articulo) {
        viewModelScope.launch {
            repository.delete(articulo)
        }
    }


}