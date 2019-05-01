package com.bytemain.pokemonfinder.mock

import android.app.Application
import com.bytemain.pokemonfinder.di.PokemonModule
import dagger.Module

@Module
class TestModule(application: Application) : PokemonModule(application) {

}