package com.vortigo.pokemonfinder.ui.pokemon.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
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

/**
 * @author rorogarcete
 * @version 0.0.1
 * Activity to search pokemons
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonSearchActivity: BaseActivity(), PokemonSearchContract.PokemonSearchView, TypeFragment.onClickListener {

    @Inject lateinit var presenter: PokemonSearchContract.PokemonSerchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_search)

        handleIntent(intent)
        setInjection()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container_types, TypeFragment.newInstance()).commit()

            supportFragmentManager.beginTransaction().replace(R.id.container_pokemons, PokemonListFragment.newInstance()).commit()
        }
    }

    override fun onResume() {
        super.onResume()
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

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.pokemon_search, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView

        searchView.queryHint = getText(R.string.action_search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.setQuery("", false)
                searchView.isIconified = true
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                //textView.setText(newText)
                // task HERE
                return true
            }
        })


        return super.onCreateOptionsMenu(menu)
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun onEntityError(error: String) {

    }

    override fun loadPokemons(types: List<Pokemon>) {

    }

    override fun onClick(item: Type) {

    }

    // Local Methods
    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                presenter.getPokemonsByName(query)
            }
        }
    }


}
