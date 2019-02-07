package com.vortigo.pokemonfinder

import android.app.Application
import android.support.annotation.VisibleForTesting
import com.vortigo.pokemonfinder.data.db.PokemonSeed
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference
import com.vortigo.pokemonfinder.di.DaggerPokemonComponent
import com.vortigo.pokemonfinder.di.PokemonComponent
import com.vortigo.pokemonfinder.di.PokemonModule
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber

/**
 * @author rorogarcete
 * @version 0.0.1
 * Application Class
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonFinderApp: Application() {

    lateinit var component : PokemonComponent
        @VisibleForTesting set

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initGraph()
        initPref()
        initRealm()

        if (PokemonPreference().getInitDate(this).isEmpty()) {
            makeSeedData()
        }
    }

    private fun initGraph() {
        component = DaggerPokemonComponent.builder()
            .pokemonModule(PokemonModule(PokemonFinderApp.instance))
            .build()
    }

    private fun initRealm() {
        Realm.init(this)
        RealmConfiguration.Builder()
            .name("pokemons-db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded().build()
    }

    private fun initPref() {
        PokemonPreference().prefs(this)
    }

    private fun makeSeedData() {
        val realm = Realm.getDefaultInstance()
        val seed = PokemonSeed(this, realm)
        seed.populateData()
    }

    companion object {
        lateinit var instance : PokemonFinderApp private set
    }

}