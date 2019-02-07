package com.vortigo.pokemonfinder.mock

import com.vortigo.pokemonfinder.di.PokemonComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(TestModule::class))
interface TestComponent : PokemonComponent {

}