package com.vortigo.pokemonfinder.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.vortigo.pokemonfinder.helper.Util

open class PokemonPreference {

    fun prefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(Util.PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun clear(context: Context) {
        prefs(context).edit().clear().apply()
    }

    fun getInitDate(context: Context): String {
        return prefs(context).getString(Util.INIT_DATA, "")
    }

    fun setInitData(context: Context, initData: String) {
        prefs(context).edit().putString(Util.INIT_DATA, initData).apply()
    }

}