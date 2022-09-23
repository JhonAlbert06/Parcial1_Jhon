package edu.ucne.parcial1_jhon.ui.aux

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jhon.data.local.entity.Aux
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class AuxListUiState(
    val auxs : List<Aux> = emptyList()
)

@HiltViewModel
class HomeViewModelAux @Inject constructor(
    //private val repository: AuxRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(AuxListUiState())
    val uiState : StateFlow<AuxListUiState> = _uiState.asStateFlow()

    /*init {
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy(auxs = list)
                }
            }
        }
    }

    fun delete(aux: Aux) {
        viewModelScope.launch {
            repository.delete(aux)
        }
    }*/


}