package com.vortigo.pokemonfinder.ui.pokemon.types

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_type_list.*
import timber.log.Timber
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

    private val typeAdapter by lazy { TypeAdapter(listener) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
       return inflater.inflate(R.layout.fragment_type_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInjection()
        configureRecyclerView()
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
            throw RuntimeException(context.toString() + " must implement OnClickListener")
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
        progress_indicator.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_indicator.visibility = View.GONE
    }

    override fun onEntityError(error: String) {
        Timber.e(error)
    }

    override fun loadTypes(types: List<Type>) {
        typeAdapter.setList(types)
    }

    //Local Methods
    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

    private fun configureRecyclerView() {
        typesRecyclerView.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            layoutManager = linearLayout
            clearOnScrollListeners()
        }

        typesRecyclerView.adapter = typeAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() : TypeFragment {
            return TypeFragment()
        }

    }
}
