package edu.iesam.pokmon.features.domain

interface PokemonRepository {

    fun getPokemons(): List<Pokemon>
    fun getPokemon(pokedexNum: String): Pokemon?

}