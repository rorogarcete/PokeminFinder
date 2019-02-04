package com.vortigo.pokemonfinder.ui.trainer

import android.os.Bundle
import android.os.PersistableBundle

import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.ui.base.BaseActivity

/**
 * @author rorogarcete
 * @version 0.0.1
 * Activity for register trainer of pokemon
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class RegisterTrainerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_trainer)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
