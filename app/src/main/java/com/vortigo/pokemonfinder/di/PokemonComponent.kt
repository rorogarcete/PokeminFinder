package com.vortigo.pokemonfinder.di

import com.vortigo.pokemonfinder.ui.pokemon.list.PokemonListFragment
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchActivity
import com.vortigo.pokemonfinder.ui.pokemon.types.TypeFragment
import com.vortigo.pokemonfinder.ui.trainer.SelectPokemonActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(PokemonModule::class))
interface PokemonComponent {
    fun inject(activity : SelectPokemonActivity)

    fun inject(activity: PokemonSearchActivity)

    fun inject(fragment : TypeFragment)

    fun inject(fragment: PokemonListFragment)
}
