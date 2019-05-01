package com.bytemain.pokemonfinder.di

import com.bytemain.pokemonfinder.ui.pokemon.list.PokemonListFragment
import com.bytemain.pokemonfinder.ui.pokemon.search.PokemonSearchActivity
import com.bytemain.pokemonfinder.ui.pokemon.types.TypeFragment
import com.bytemain.pokemonfinder.ui.trainer.SelectPokemonActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author rorogarcete
 * @version 0.0.1
 * DI for pokemon UI component
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
@Singleton
@Component(modules = arrayOf(PokemonModule::class))
interface PokemonComponent {
    fun inject(activity : SelectPokemonActivity)

    fun inject(activity: PokemonSearchActivity)

    fun inject(fragment : TypeFragment)

    fun inject(fragment: PokemonListFragment)
}
