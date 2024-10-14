package edu.iesam.pokmon.features.domain

class GetPokemonUseCase (val pokemonRepository: PokemonRepository) {

    operator fun invoke(pokedexNum: String): Pokemon?{
        return pokemonRepository.getPokemon(pokedexNum)
    }

}