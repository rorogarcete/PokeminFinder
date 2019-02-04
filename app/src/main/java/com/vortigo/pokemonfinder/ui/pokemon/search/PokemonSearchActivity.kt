package com.vortigo.pokemonfinder.ui.pokemon.search

import android.os.Bundle

import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.ui.base.BaseActivity

/**
 * @author rorogarcete
 * @version 0.0.1
 * Activity to search pokemons
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonSearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_search)
    }
}
