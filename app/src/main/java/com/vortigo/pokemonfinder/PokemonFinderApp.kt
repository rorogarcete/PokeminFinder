package com.vortigo.pokemonfinder

import android.app.Application
import com.vortigo.pokemonfinder.data.db.PokemonSeed
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference
import io.realm.Realm

/**
 * @author rorogarcete
 * @version 0.0.1
 * Application Class
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonFinderApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initPref()

        initRealm()

        if (!PokemonPreference().getInitDate(this).isEmpty()) {
            makeSeedData()
        }
    }

    private fun initRealm() {
        Realm.init(this)
    }

    private fun initPref() {
        PokemonPreference().prefs(this)
    }

    private fun makeSeedData() {
        val realm = Realm.getDefaultInstance()
        val seed = PokemonSeed(this, realm)
        seed.populateData()
    }

}