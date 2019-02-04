package com.vortigo.pokemonfinder.ui.pokemon.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.domain.model.Pokemon
import com.vortigo.pokemonfinder.ui.pokemon.list.PokemonFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_pokemon.view.*

/**
 * @author rorogarcete
 * @version 0.0.1
 * Adapter of the [PokemonFragment]
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonAdapter(
    private val mValues: List<Pokemon>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Pokemon
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mContentView.text = item.name

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.txt_name_pokemon
    }
}
