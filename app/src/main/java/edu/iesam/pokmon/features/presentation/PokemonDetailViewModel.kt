package edu.iesam.pokmon.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.pokmon.features.domain.GetPokemonUseCase
import edu.iesam.pokmon.features.domain.Pokemon
import edu.iesam.pokmon.features.domain.GetPokemonsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDetailViewModel (private val getPokemonUseCase: GetPokemonUseCase) : ViewModel(){

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun loadPokemon(pokedexNum: String){
        viewModelScope.launch(Dispatchers.IO){
            val pokemon = getPokemonUseCase.invoke(pokedexNum)
            _uiState.postValue(UiState(pokemon = pokemon))
        }
    }

    data class UiState(
        val isLoading : Boolean? = false,
        val errApp : ErrorApp? = null,
        val pokemon : Pokemon? = null
    )

}