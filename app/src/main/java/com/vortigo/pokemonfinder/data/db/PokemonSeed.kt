package com.vortigo.pokemonfinder.data.db

import android.content.Context
import com.vicpin.krealmextensions.transaction
import com.vortigo.pokemonfinder.data.model.PokemonTable
import com.vortigo.pokemonfinder.data.model.TypeTable
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference
import com.vortigo.pokemonfinder.helper.Util
import io.realm.Realm
import org.json.JSONObject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Seed Class for retrieve data from JSON files and save with Realm.io
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonSeed(
    private val context: Context,
    private val realm: Realm) {

    val POKEMONS_FILE = "pokemons.json"
    val TYPES_FILE = "types.json"
    val TYPES_RESULTS = "results"

    fun populateData() {
        realm.transaction {
            createPokemons()
            createTypes()
        }

        PokemonPreference().setInitData(context, Util.INIT_DATA)
    }

    private fun loadJSON(jsonFile: String): String {
        val inputStream = context.assets.open(jsonFile)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        return String(buffer)
    }

    private fun createPokemons() {
        val pokemons = loadJSON(POKEMONS_FILE)
        realm.createAllFromJson(PokemonTable::class.java, pokemons)
    }

    private fun createTypes() {
        val json = loadJSON(TYPES_FILE)
        val obj = JSONObject(json)
        val types = obj.getJSONArray(TYPES_RESULTS)

        realm.createAllFromJson(TypeTable::class.java, types)
    }

}