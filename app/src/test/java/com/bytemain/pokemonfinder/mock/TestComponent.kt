package com.bytemain.pokemonfinder.mock

import com.bytemain.pokemonfinder.di.PokemonComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(TestModule::class))
interface TestComponent : PokemonComponent {

}