package edu.iesam.pokmon.features.domain

class GetPokemonsUseCase (val pokemonRepository: PokemonRepository) {

    operator fun invoke(): List<Pokemon>{
        return pokemonRepository.getPokemons()
    }

}