package edu.iesam.pokmon.features.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.pokmon.R
import edu.iesam.pokmon.databinding.FragmentPokemonDetailBinding
import edu.iesam.pokmon.features.domain.Pokemon

class PokemonDetailFragment : Fragment() {

    private var _binding : FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel


    private val pokemonArgs : PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = PokemonFactory()
        viewModel = factory.getPokemonDetailViewModel()

        setupObvserver()

    }

    private fun bindData(pokemon: Pokemon){
        binding.apply {
            pokedexNum.text = pokemon.pokedexNum
            name.text = pokemon.name
            hability.text = pokemon.hability
            type.text = pokemon.type
            img.loadUrl(pokemon.img)

        }
    }

    private fun setupObvserver(){
        viewModel.loadPokemon(pokemonArgs.pokedexNum)
        val observer = Observer<PokemonDetailViewModel.UiState>{ uistate ->
            uistate.pokemon?.let { pokemon ->
                bindData(pokemon)
            }

        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

}