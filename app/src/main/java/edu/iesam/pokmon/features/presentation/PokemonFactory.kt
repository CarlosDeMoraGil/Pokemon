package edu.iesam.pokmon.features.presentation

import edu.iesam.pokmon.features.data.PokemonDataRepository
import edu.iesam.pokmon.features.data.remote.PokemonMockRemoteDataSource
import edu.iesam.pokmon.features.domain.GetPokemonUseCase
import edu.iesam.pokmon.features.domain.GetPokemonsUseCase

class PokemonFactory {

    private val pokemonDataRepository = PokemonDataRepository(PokemonMockRemoteDataSource())
    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonDataRepository)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)

    fun getPokemonsViewModel(): PokemonsViewModel{
        return PokemonsViewModel(getPokemonsUseCase)
    }

    fun getPokemonDetailViewModel(): PokemonDetailViewModel{
        return PokemonDetailViewModel(getPokemonUseCase)
    }

}