package com.bytemain.pokemonfinder.ui.main

import android.content.Intent
import android.os.Bundle
import com.bytemain.pokemonfinder.PokemonFinderApp
import com.bytemain.pokemonfinder.R
import com.bytemain.pokemonfinder.data.prefs.PokemonPreference
import com.bytemain.pokemonfinder.ui.base.BaseActivity
import com.bytemain.pokemonfinder.ui.pokemon.search.PokemonSearchActivity
import com.bytemain.pokemonfinder.ui.trainer.RegisterTrainerActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author rorogarcete
 * @version 0.0.1
 * Main Bytemain of the Application
*/
class MainActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!PokemonFinderApp.sIsSessionActive) {
            PokemonFinderApp.sIsSessionActive = true
            openStartActivity()
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

    private fun openStartActivity() {
        startActivity(Intent(this, SplashActivity::class.java))
        finish()
    }
}
