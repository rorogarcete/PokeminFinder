package com.vortigo.pokemonfinder.ui.pokemon.list

import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

interface PokemonListContract {

    interface PokemonView: View {
        fun loadPokemons(types: List<Pokemon>)
    }

    interface PokemonPresenter: Presenter<PokemonView> {
        fun getPokemons()
    }

}