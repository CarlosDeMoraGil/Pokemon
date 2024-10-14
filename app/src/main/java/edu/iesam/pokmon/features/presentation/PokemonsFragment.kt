package edu.iesam.pokmon.features.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.pokmon.databinding.FragmentPokemonsBinding
import edu.iesam.pokmon.features.domain.Pokemon

class PokemonsFragment : Fragment() {

    private var _binding: FragmentPokemonsBinding? = null
    private val binding get() = _binding!!

    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = PokemonFactory()
        viewModel = factory.getPokemonsViewModel()

        setupObvserver()
        viewModel.loadPokemons()

    }

    private fun bindData(pokemons: List<Pokemon>){
        binding.apply {
            pokemon1.apply {
                pokemon1Name.text = pokemons[0].name
                pokemon1Id.text = pokemons[0].pokedexNum
                moviesImg1.loadUrl(pokemons[0].img)
                setOnClickListener{
                    navigateToDetails(pokemons[0].pokedexNum)
                }
            }
            pokemon2.apply {
                pokemon2Name.text = pokemons[1].name
                pokemon2Id.text = pokemons[1].pokedexNum
                moviesImg2.loadUrl(pokemons[1].img)
                setOnClickListener{
                    navigateToDetails(pokemons[1].pokedexNum)
                }
            }
            pokemon3.apply {
                pokemon3Name.text = pokemons[2].name
                pokemon3Id.text = pokemons[2].pokedexNum
                moviesImg3.loadUrl(pokemons[2].img)
                setOnClickListener{
                    navigateToDetails(pokemons[2].pokedexNum)
                }
            }
            pokemon4.apply {
                pokemon4Name.text = pokemons[3].name
                pokemon4Id.text = pokemons[3].pokedexNum
                moviesImg4.loadUrl(pokemons[3].img)
                setOnClickListener{
                    navigateToDetails(pokemons[3].pokedexNum)
                }
            }

        }
    }

    private fun setupObvserver(){
        val observer = Observer<PokemonsViewModel.UiState>{ uistate ->
            uistate.pokemons?.let { pokemons ->
                bindData(pokemons)
            }

        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun navigateToDetails(pokedexNum: String){
        findNavController().navigate(
            PokemonsFragmentDirections
                .fromPokemonsToPokemonDetail(pokedexNum)
        )
    }

}