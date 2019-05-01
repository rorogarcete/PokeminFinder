package com.bytemain.pokemonfinder.helper

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author rorogarcete
 * @version 0.0.1
 * Helper class for load Image with [Glide]
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
object LoadImage {
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}
