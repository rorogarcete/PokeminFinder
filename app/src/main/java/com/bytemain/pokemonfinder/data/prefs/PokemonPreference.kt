package com.bytemain.pokemonfinder.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.bytemain.pokemonfinder.helper.Util

/**
 * @author rorogarcete
 * @version 0.0.1
 * Class preference for application
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
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

    fun getTypeFavorite(context: Context): String {
        return prefs(context).getString(Util.TYPE_FAVORITE, "")
    }

    fun setTypeFavorite(context: Context, typeFavorite: String) {
        prefs(context).edit().putString(Util.TYPE_FAVORITE, typeFavorite).apply()
    }

}