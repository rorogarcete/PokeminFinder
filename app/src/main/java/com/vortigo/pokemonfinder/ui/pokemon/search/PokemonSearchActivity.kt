package com.vortigo.pokemonfinder.ui.pokemon.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.BaseActivity
import com.vortigo.pokemonfinder.ui.pokemon.list.PokemonListFragment
import com.vortigo.pokemonfinder.ui.pokemon.types.TypeFragment
import javax.inject.Inject
import android.graphics.Color
import android.os.Build
import android.view.MenuItem
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference
import timber.log.Timber

/**
 * @author rorogarcete
 * @version 0.0.1
 * Activity to search pokemons
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonSearchActivity: BaseActivity(), PokemonSearchContract.PokemonSearchView, TypeFragment.onClickListener {

    @Inject lateinit var presenter: PokemonSearchContract.PokemonSerchPresenter

    private val pokemonListFragment = PokemonListFragment.newInstance()

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_search)

        progressBar = findViewById(R.id.progress_indicator)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        whiteNotificationBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_types, TypeFragment.newInstance()).commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.container_pokemons, pokemonListFragment).commit()
        }
    }


    override fun onResume() {
        super.onResume()
        setInjection()
        presenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish(ActivityAnimation.SLIDE_RIGHT)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pokemon_search, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.maxWidth = Integer.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.getPokemonsByFilter(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                presenter.getPokemonsByFilter(query)
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()

        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun onEntityError(error: String) {
        Timber.e(error)
    }

    override fun loadPokemons(pokemons: List<Pokemon>) {
        pokemonListFragment.loadPokemons(pokemons)
    }

    override fun onClick(item: Type) {
        presenter.getPokemonsByType(item.name)

        PokemonPreference().setTypeFavorite(this, item.name)
    }

    // Local Methods
    private fun whiteNotificationBar(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = view.getSystemUiVisibility()
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.setSystemUiVisibility(flags)
            window.statusBarColor = Color.WHITE
        }
    }

    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

}
