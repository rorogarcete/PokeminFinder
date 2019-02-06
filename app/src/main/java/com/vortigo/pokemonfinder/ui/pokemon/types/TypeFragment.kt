package com.vortigo.pokemonfinder.ui.pokemon.types

import android.content.Context
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
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.BaseFragment
import javax.inject.Inject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Fragment representing list of Type Pokemons
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class TypeFragment: BaseFragment(), TypeContract.TypeView {

    @Inject lateinit var presenter: TypeContract.TypePresenter

    private var listener: onClickListener? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var typeAdapter: TypeAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_type_list, container, false)

        recyclerView = view.findViewById(R.id.typesRecyclerView)
        progressBar = view.findViewById(R.id.progress_indicator)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInjection()
        presenter.attachView(this)
        presenter.getFavoriteTypes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface onClickListener {
        fun onClick(item: Type)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun onEntityError(error: String) { }

    override fun loadTypes(types: List<Type>) {
        typeAdapter = TypeAdapter(types, listener)

        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = typeAdapter
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
