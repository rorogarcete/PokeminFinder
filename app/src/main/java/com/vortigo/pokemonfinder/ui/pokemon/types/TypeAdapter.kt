package com.vortigo.pokemonfinder.ui.pokemon.types

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.pokemon.types.TypeFragment.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_type.view.*

/**
 * @author rorogarcete
 * @version 0.0.1
 * Adapter of the [TypeFragment]
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class TypeAdapter(
    private val types: List<Type>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<TypeAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Type
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_type, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = types[position]
        holder.mIdView.text = item.name

        Glide.with(holder.imgType.context)
            .load(item.thumbnailImage)
            .into(holder.imgType)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = types.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.txt_name_type
        val imgType: ImageView = mView.img_type_pokemon
    }
}
