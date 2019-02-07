package com.vortigo.pokemonfinder.mock

import android.app.Application
import com.vortigo.pokemonfinder.di.PokemonModule
import dagger.Module

@Module
class TestModule(application: Application) : PokemonModule(application) {

}