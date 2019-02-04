package com.vortigo.pokemonfinder.ui.main

import android.os.Bundle

import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.ui.base.BaseActivity

/**
 * @author rorogarcete
 * @version 0.0.1
 * Main Activity of the Application
 * Copyright 2019 Vortigo Inc. All rights reserved
*/
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
