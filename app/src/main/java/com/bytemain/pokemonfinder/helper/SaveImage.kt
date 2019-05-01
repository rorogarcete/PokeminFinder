package com.bytemain.pokemonfinder.helper

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

/**
 * @author rorogarcete
 * @version 0.0.1
 * Util class for saveImage in file
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
class SaveImage {
    companion object {
        fun saveFromUri(context : Context, origin : Uri, destination : File) : Boolean {
            try {
                if (!destination.exists()){
                    destination.createNewFile()
                }
                val input: InputStream = context.contentResolver.openInputStream(origin)

                val options = BitmapFactory.Options()
                options.inSampleSize = 4

                val bmp = BitmapFactory.decodeStream(input, null, options)
                val bytes = FileOutputStream(destination)
                bmp.compress(Bitmap.CompressFormat.JPEG, 80, bytes)

                return true

            } catch (e : Exception){
                Timber.e(e)
                return false
            }
        }
    }
}