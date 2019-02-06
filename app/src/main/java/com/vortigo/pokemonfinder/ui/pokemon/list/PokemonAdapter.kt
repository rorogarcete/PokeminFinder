package com.vortigo.pokemonfinder.ui.pokemon.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Pokemon
import kotlinx.android.synthetic.main.fragment_pokemon.view.*

/**
 * @author rorogarcete
 * @version 0.0.1
 * Adapter of the [PokemonListFragment]
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonAdapter(private val pokemons: List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokemons[position]
        holder.mContentView.text = item.name

        Glide.with(holder.imgPokemon.context)
            .load(item.thumbnailImage)
            .into(holder.imgPokemon)
    }

    override fun getItemCount(): Int = pokemons.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.txt_name_pokemon
        val imgPokemon: ImageView = mView.img_pokemon
    }
}
