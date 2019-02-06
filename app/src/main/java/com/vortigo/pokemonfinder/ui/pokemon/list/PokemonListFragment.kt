package com.vortigo.pokemonfinder.ui.pokemon.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.BaseFragment
import javax.inject.Inject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Fragment representing list of the Pokemons
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonListFragment: BaseFragment(), PokemonListContract.PokemonView {

    @Inject lateinit var presenter: PokemonListContract.PokemonPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        recyclerView = view.findViewById(R.id.pokemonRecyclerView)
        progressBar = view.findViewById(R.id.progress_indicator)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInjection()
        presenter.attachView(this)
        presenter.getPokemons()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun onEntityError(error: String) {

    }

    override fun loadPokemons(pokemons: List<Pokemon>) {
        pokemonAdapter = PokemonAdapter(pokemons)

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = pokemonAdapter
    }

    //Local Methods
    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(): PokemonListFragment {
            val fragment = PokemonListFragment()

            return fragment
        }
    }
}
