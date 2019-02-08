package com.vortigo.pokemonfinder.di

import android.app.Application
import android.content.Context
import com.vortigo.pokemonfinder.data.DataSource
import com.vortigo.pokemonfinder.data.db.PokemonDatabase
import com.vortigo.pokemonfinder.ui.pokemon.list.PokemonListContract
import com.vortigo.pokemonfinder.ui.pokemon.list.PokemonListPresenter
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchContract
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchPresenter
import com.vortigo.pokemonfinder.ui.pokemon.types.TypeContract
import com.vortigo.pokemonfinder.ui.pokemon.types.TypePresenter
import com.vortigo.pokemonfinder.ui.trainer.TrainerContract
import com.vortigo.pokemonfinder.ui.trainer.TrainerPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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