package edu.iesam.pokmon.features.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.pokmon.databinding.ViewPokemonItemBinding
import edu.iesam.pokmon.features.domain.Pokemon

class PokemonViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewPokemonItemBinding

    fun bind(model: Pokemon){
        binding = ViewPokemonItemBinding.bind(view)

        binding.apply {
            img.loadUrl(model.img)
            id.text = model.pokedexNum
            name.text = model.name
        }
    }

}