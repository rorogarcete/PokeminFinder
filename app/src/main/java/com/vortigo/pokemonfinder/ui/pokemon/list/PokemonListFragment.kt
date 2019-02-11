package com.vortigo.pokemonfinder.ui.pokemon.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.BaseFragment
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import timber.log.Timber

/**
 * @author rorogarcete
 * @version 0.0.1
 * Fragment representing list of Pokemons for Type
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonListFragment: BaseFragment(), PokemonListContract.PokemonView {

    @Inject lateinit var presenter: PokemonListContract.PokemonPresenter

    private val adapter by lazy { PokemonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInjection()
        configureRecyclerView()
        makeOrderedPokemon()
        presenter.attachView(this)
        presenter.getPokemonsFavoriteByType(PokemonPreference().getTypeFavorite(activity!!.baseContext))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showProgress() {
        progress_indicator.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_indicator.visibility = View.GONE
    }

    override fun onEntityError(error: String) {
        Timber.e(error)
    }

    override fun loadPokemons(pokemons: List<Pokemon>) {
        adapter.setList(pokemons)
    }

    //Local Methods
    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

    private fun configureRecyclerView() {
        pokemonRecyclerView.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }

        pokemonRecyclerView.adapter = adapter
    }

    private fun makeOrderedPokemon() {
        container_ordered.setOnClickListener {
            presenter.makeOrderedPokemonByName(PokemonPreference().getTypeFavorite(activity!!.baseContext))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): PokemonListFragment {
            return PokemonListFragment()
        }
    }
}
