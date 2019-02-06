package com.vortigo.pokemonfinder.helper

import android.widget.ArrayAdapter
import com.vortigo.pokemonfinder.models.Type
import android.view.ViewGroup
import android.widget.TextView
import android.view.LayoutInflater
import android.content.Context
import android.support.annotation.LayoutRes
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.vortigo.pokemonfinder.R

/**
 * @author rorogarcete
 * @version 0.0.1
 * Spinner Adapter custom for show image with textView
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class SpinnerTypeAdapter(context: Context, @LayoutRes private val layoutResource: Int, private val types: List<Type>)
    : ArrayAdapter<Type> (context, layoutResource, types) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)
    }

    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(layoutResource, parent, false)

        val item = types[position]
        val img = view.findViewById<ImageView>(R.id.img_type)
        val txt = view.findViewById<TextView>(R.id.txt_type_name)

//        Glide.with(img.context)
//            .load(types[position].thumbnailImage)
//            .into(img)

        LoadImage.setImageUrl(img, item.thumbnailImage)
        txt.text = item.name

        return view
    }


}