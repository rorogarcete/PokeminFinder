package com.vortigo.pokemonfinder.ui.main

import android.content.Intent
import android.os.Bundle
import com.vortigo.pokemonfinder.PokemonFinderApp
import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.data.prefs.PokemonPreference
import com.vortigo.pokemonfinder.ui.base.BaseActivity
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchActivity
import com.vortigo.pokemonfinder.ui.trainer.RegisterTrainerActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author rorogarcete
 * @version 0.0.1
 * Main Activity of the Application
 * Copyright 2019 Vortigo Inc. All rights reserved
*/
class MainActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!PokemonFinderApp.sIsSessionActive) {
            PokemonFinderApp.sIsSessionActive = true
            verStartActivity()
        } else {
            setupInit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish(BaseActivity.ActivityAnimation.SLIDE_RIGHT)
    }

    private fun goToRegisterTrainer() {
        startActivity(Intent(this, RegisterTrainerActivity::class.java), ActivityAnimation.SLIDE_LEFT)
    }

    private fun setupInit() {
        if (!PokemonPreference().getTypeFavorite(this).isEmpty()) {
            startActivity(Intent(this, PokemonSearchActivity::class.java), ActivityAnimation.SLIDE_LEFT)
            finish()
        } else {
            setContentView(R.layout.activity_main)

            btn_lets_go.setOnClickListener {
                goToRegisterTrainer()
            }
        }
    }

    private fun verStartActivity() {
        startActivity(Intent(this, SplashActivity::class.java))
        finish()
    }
}
