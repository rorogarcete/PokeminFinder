package com.vortigo.pokemonfinder.data.db

import android.content.Context
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Type
import org.json.JSONArray
import org.json.JSONObject

class PokemonLocal(private val context: Context) { // DataSource

    var POKEMONS: MutableList<Pokemon> = mutableListOf()

    var TYPES: MutableList<Type> = mutableListOf()

    init {
        createTypes()
        createPokemons()
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

            val pokemon = Pokemon(
                item.getInt("id"),
                //item.get("abilities") as RealmList<String>,
                item.getString("detailPageURL"),
                item.getDouble("weight"),
                //item.get("weakness") as RealmList<String>,
                item.getString("number"),
                item.getDouble("height"),
                item.getString("collectibles_slug"),
                item.getString("featured"),
                item.getString("slug"),
                item.getString("name"),
                item.getString("thumbnailAltText"),
                item.getString("thumbnailImage"),
                item.getJSONArray("type") as List<Type>
            )

            POKEMONS.add(pokemon)
        }
    }

    private fun createTypes() {
        val json = loadJSON(TYPES_FILE)
        val obj = JSONObject(json)
        val types = obj.getJSONArray(TYPES_RESULTS)

        for (i in 0..(types.length() - 1)) {
            val item = types.getJSONObject(i)

            val type = Type(
                item.getString("name"),
                item.getString("thumbnailImage")
            )

            TYPES.add(type)
        }
    }

    companion object {
        val POKEMONS_FILE = "pokemons.json"
        val TYPES_FILE = "types.json"
        val TYPES_RESULTS = "results"
    }

//    override fun getTypes(): Observable<List<Type>> {
//
//    }
//
//    // TODO add filter by type
//    override fun getPokemonsByType(type: String): Observable<List<Pokemon>> {
//
//    }
//
//    override fun getPokemonsByFilter(query: String): Observable<List<Pokemon>> {
//
//    }
//
//    // TODO Change for Completable
//    override fun saveTrainer(trainer: Trainer) {
//
//    }
//
//    // TODO Change query for get one Trainer
//    override fun getTrainer(): Observable<Trainer> {
//        return null
//    }
//
//    override fun getTypePokemonFavorite(): Observable<List<Trainer>> {
//
//    }

}