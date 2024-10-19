package edu.iesam.pokmon.features.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import edu.iesam.pokmon.databinding.ActivityPokemonsBinding
import edu.iesam.pokmon.databinding.FragmentPokemonsBinding

class PokemonsFragment : Fragment() {

    private lateinit var binding: FragmentPokemonsBinding

    private val pokemonAdapter = PokemonAdapter()

    private lateinit var factory: PokemonFactory
    private lateinit var viewModel: PokemonsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = PokemonFactory()
        viewModel = factory.getPokemonsViewModel()

        setupObvserver()
        setupView()

        viewModel.loadPokemons()

    }

    private fun setupView() {
        binding.apply {
            list.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            list.adapter = pokemonAdapter
        }
    }


    private fun setupObvserver(){
        val observer = Observer<PokemonsViewModel.UiState>{ uistate ->
            uistate.pokemons?.let { pokemons ->
                pokemonAdapter.setDataList(pokemons)
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