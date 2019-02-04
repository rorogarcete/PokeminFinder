package com.vortigo.pokemonfinder

import android.app.Application
import com.vortigo.pokemonfinder.data.db.PokemonSeed
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

        Realm.init(this)
        makeSeedData()
    }

    private fun makeSeedData() {
        val realm = Realm.getDefaultInstance()
        val seed = PokemonSeed(this, realm)
        seed.populateData()
    }

}