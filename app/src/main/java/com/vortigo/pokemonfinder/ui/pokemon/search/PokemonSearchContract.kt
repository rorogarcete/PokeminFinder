package com.vortigo.pokemonfinder.ui.pokemon.search

import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

interface PokemonSearchContract {

    interface PokemonSearchView: View {
        fun loadPokemons(pokemons: List<Pokemon>)
    }

    interface PokemonSerchPresenter: Presenter<PokemonSearchView> {
        fun getPokemonsByName(name: String)
        fun getPokemonsByType(type: String)
    }

}