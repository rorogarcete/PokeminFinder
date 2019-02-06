package com.vortigo.pokemonfinder.helper

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vortigo.pokemonfinder.R

/**
 * @author rorogarcete
 * @version 0.0.1
 * Helper class for load Image with [Glide]
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
object LoadImage {
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String?) {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.poke_ball)
        requestOptions.error(R.drawable.poke_ball)

        Glide.with(imageView.context)
            .setDefaultRequestOptions(requestOptions)
            .load(url).into(imageView)

    }
}
