package com.bytemain.pokemonfinder.ui.trainer

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.bytemain.pokemonfinder.R
import com.bytemain.pokemonfinder.helper.Util
import com.bytemain.pokemonfinder.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_register_trainer.*

/**
 * @author rorogarcete
 * @version 0.0.1
 * Activity for register trainer of pokemon
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
class RegisterTrainerActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_trainer)

        img_goto_select.setOnClickListener {
            goToSelectPokemonActivity()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish(ActivityAnimation.SLIDE_RIGHT)
    }

    private fun goToSelectPokemonActivity() {
        val trainerName = edt_name.text.toString()

        if (!trainerName.isEmpty()) {
            val intent = Intent(this, SelectPokemonActivity::class.java)
            intent.putExtra(Util.TRAINER_NAME, trainerName)
            startActivity(Intent(intent), ActivityAnimation.SLIDE_LEFT)
        } else {
            val error = "Name is requiered.!"
            Snackbar.make(container_trainer, error, Snackbar.LENGTH_LONG).show()
        }
    }
}
