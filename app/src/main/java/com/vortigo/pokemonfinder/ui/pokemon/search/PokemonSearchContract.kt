package com.vortigo.pokemonfinder.ui.pokemon.search

import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contract class for [PokemonSearchActivity]
 * Copyright 2019 Vortigo Inc. All rights reserved
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