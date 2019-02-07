package com.vortigo.pokemonfinder.ui.pokemon.list

import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contract for [PokemonListFragment]
 * Copyright 2019 Vortigo Inc. All rights reserved
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