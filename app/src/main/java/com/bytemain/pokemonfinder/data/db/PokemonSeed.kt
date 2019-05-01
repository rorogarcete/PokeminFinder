package com.bytemain.pokemonfinder.data.db

import android.content.Context
import com.vicpin.krealmextensions.queryFirst
import com.vicpin.krealmextensions.save
import com.vicpin.krealmextensions.transaction
import com.bytemain.pokemonfinder.data.model.PokemonTable
import com.bytemain.pokemonfinder.data.model.TypeTable
import com.bytemain.pokemonfinder.data.prefs.PokemonPreference
import com.bytemain.pokemonfinder.helper.Util
import io.realm.Realm
import io.realm.RealmList
import org.json.JSONArray
import org.json.JSONObject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Seed Class for retrieve data from JSON files and save with Realm.io
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
class PokemonSeed(private val context: Context, private val realm: Realm) {

    fun populateData() {

        realm.transaction {
            createTypes()
            createPokemons()
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
        val pokemonInput = loadJSON(POKEMONS_FILE)

        val jsonPokemons = JSONArray(pokemonInput)

        for (i in 0..(jsonPokemons.length() - 1)) {
            val item = jsonPokemons.getJSONObject(i)
            val types = item.getJSONArray("type")
            val typesTable: RealmList<TypeTable> = RealmList()

            for (j in 0..(types.length() - 1)) {
                val t = types.get(j)
                val type = TypeTable().queryFirst { equalTo("name", t.toString()) }

                if (type != null) typesTable.add(type)
            }

            PokemonTable(
                item.getInt("id"),
                item.getString("detailPageURL").toString(),
                item.getDouble("weight"),
                item.getString("number"),
                item.getDouble("height"),
                item.getString("collectibles_slug"),
                item.getString("featured"),
                item.getString("slug"),
                item.getString("name"),
                item.getString("thumbnailAltText"),
                item.getString("thumbnailImage"),
                typesTable
            ).save()
        }
    }

    private fun createTypes() {
        val json = loadJSON(TYPES_FILE)
        val obj = JSONObject(json)
        val types = obj.getJSONArray(TYPES_RESULTS)

        realm.createAllFromJson(TypeTable::class.java, types)
    }

    companion object {
        val POKEMONS_FILE = "pokemons.json"
        val TYPES_FILE = "types.json"
        val TYPES_RESULTS = "results"
    }

}