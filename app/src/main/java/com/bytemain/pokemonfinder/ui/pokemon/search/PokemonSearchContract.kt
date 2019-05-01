package com.bytemain.pokemonfinder.ui.pokemon.search

import com.bytemain.pokemonfinder.models.Pokemon
import com.bytemain.pokemonfinder.ui.base.Presenter
import com.bytemain.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contract class for [PokemonSearchActivity]
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
interface PokemonSearchContract {
    interface PokemonSearchView: View {
        fun loadPokemons(pokemons: List<Pokemon>)
    }

    interface PokemonSerchPresenter: Presenter<PokemonSearchView> {
        fun getPokemonsByFilter(name: String)
        fun getPokemonsByType(type: String)
    }
}