package com.bytemain.pokemonfinder.ui.pokemon.list

import com.bytemain.pokemonfinder.models.Pokemon
import com.bytemain.pokemonfinder.ui.base.Presenter
import com.bytemain.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contract for [PokemonListFragment]
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
interface PokemonListContract {

    interface PokemonView: View {
        fun loadPokemons(pokemons: List<Pokemon>)
    }

    interface PokemonPresenter: Presenter<PokemonView> {
        fun getPokemonsFavoriteByType(type: String)
        fun makeOrderedPokemonByName(type: String)
    }

}