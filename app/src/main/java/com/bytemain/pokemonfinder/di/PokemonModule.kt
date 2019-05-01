package com.bytemain.pokemonfinder.di

import android.app.Application
import android.content.Context
import com.bytemain.pokemonfinder.data.DataSource
import com.bytemain.pokemonfinder.data.db.PokemonDatabase
import com.bytemain.pokemonfinder.ui.pokemon.list.PokemonListContract
import com.bytemain.pokemonfinder.ui.pokemon.list.PokemonListPresenter
import com.bytemain.pokemonfinder.ui.pokemon.search.PokemonSearchContract
import com.bytemain.pokemonfinder.ui.pokemon.search.PokemonSearchPresenter
import com.bytemain.pokemonfinder.ui.pokemon.types.TypeContract
import com.bytemain.pokemonfinder.ui.pokemon.types.TypePresenter
import com.bytemain.pokemonfinder.ui.trainer.TrainerContract
import com.bytemain.pokemonfinder.ui.trainer.TrainerPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author rorogarcete
 * @version 0.0.1
 * DI for presenter
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
@Module
open class PokemonModule(private val application: Application) {

    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun providesDataSource(): DataSource {
        return PokemonDatabase()
    }

    @Provides
    @Singleton
    fun provideTrainerPresenter(dataSource : DataSource) : TrainerContract.TrainerPresenter {
        return TrainerPresenter(dataSource)
    }

    @Provides
    @Singleton
    fun providePokemonSearchPresenter(dataSource : DataSource) : PokemonSearchContract.PokemonSerchPresenter {
        return PokemonSearchPresenter(dataSource)
    }

    @Provides
    @Singleton
    fun providePokemonListPresenter(dataSource : DataSource) : PokemonListContract.PokemonPresenter {
        return PokemonListPresenter(dataSource)
    }

    @Provides
    @Singleton
    fun provideTypePresenter(dataSource : DataSource) : TypeContract.TypePresenter {
        return TypePresenter(dataSource)
    }

}