package edu.iesam.pokmon.features.data.remote

import edu.iesam.pokmon.features.domain.Pokemon

class PokemonMockRemoteDataSource {

    val pokemons = listOf(
        Pokemon("483", "Dialga", "Acero/Dragon", "Poder Pasado", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/483.png"),
        Pokemon("484", "Palkia", "Agua/Dragon", "Poder Pasado", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/484.png"),
        Pokemon("487", "Giratina", "Fantasma/Dragon", "Levitacion", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/487_f2.png"),
        Pokemon("493", "Arceus", "Normal", "Multitipo", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/493.png")
    )

    fun obtainPokemons(): List<Pokemon>{
        return pokemons
    }

    fun getPokemon(pokedexNum: String): Pokemon?{
        return pokemons.firstOrNull{pokemon ->
            pokemon.pokedexNum == pokedexNum
        }
    }

}