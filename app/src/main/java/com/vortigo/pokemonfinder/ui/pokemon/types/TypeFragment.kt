package com.vortigo.pokemonfinder.ui.pokemon.types

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_type_list.view.*
import javax.inject.Inject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Fragment representing list of Type Pokemons
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class TypeFragment: BaseFragment(), TypeContract.TypeView {

    @Inject lateinit var presenter: TypeContract.TypePresenter

    private var listener: OnListFragmentInteractionListener? = null
    private var typeAdapter: TypeAdapter? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInjection()
        presenter.attachView(this)
        presenter.getFavoriteTypes()
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_type_list, container, false)

        val recyclerView = view.typesRecyclerView as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = typeAdapter

        progressBar = view.findViewById(R.id.progress_indicator)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Type)
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.GONE
    }

    override fun onEntityError(error: String) { }

    override fun loadTypes(types: List<Type>) {
        typeAdapter = TypeAdapter(types, listener)
    }

    //Local Methods
    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

    companion object {

        @JvmStatic
        fun newInstance() : TypeFragment {
            val fragment = TypeFragment()

            return fragment
        }

    }
}
