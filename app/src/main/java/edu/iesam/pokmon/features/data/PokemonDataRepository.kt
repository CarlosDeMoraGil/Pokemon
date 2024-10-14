package edu.iesam.pokmon.features.data

import edu.iesam.pokmon.features.data.remote.PokemonMockRemoteDataSource
import edu.iesam.pokmon.features.domain.Pokemon
import edu.iesam.pokmon.features.domain.PokemonRepository

class PokemonDataRepository (pokemonMockRemoteDataSource: PokemonMockRemoteDataSource) : PokemonRepository {

    private val remote = pokemonMockRemoteDataSource

    override fun getPokemons(): List<Pokemon> {
        return remote.obtainPokemons()
    }

    override fun getPokemon(pokedexNum: String): Pokemon? {
        return remote.getPokemon(pokedexNum)
    }
}