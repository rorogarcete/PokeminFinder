package com.vortigo.pokemonfinder.ui.pokemon.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.BaseFragment
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference
import timber.log.Timber

/**
 * @author rorogarcete
 * @version 0.0.1
 * Fragment representing list of Pokemons for Type
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonListFragment: BaseFragment(), PokemonListContract.PokemonView {

    @Inject lateinit var presenter: PokemonListContract.PokemonPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private var pokemonAdapter = PokemonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        progressBar = view.findViewById(R.id.progress_indicator)

        recyclerView = view.findViewById(R.id.pokemonRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.hasFixedSize()
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = pokemonAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInjection()
        presenter.attachView(this)

        getPokemonsFavorite()
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
        Timber.e(error)
    }

    override fun loadPokemons(pokemons: List<Pokemon>) {
        pokemonAdapter.setList(pokemons)
        pokemonAdapter.notifyDataSetChanged()
    }

    //Local Methods
    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

    private fun getPokemonsFavorite() {
        val type = PokemonPreference().getTypeFavorite(activity!!.baseContext)
        presenter.getPokemonsFavoriteByType(type)
    }

    companion object {
        @JvmStatic
        fun newInstance(): PokemonListFragment {
            val fragment = PokemonListFragment()

            return fragment
        }
    }
}
