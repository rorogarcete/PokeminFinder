package com.vortigo.pokemonfinder.ui.trainer

import android.os.Bundle

import com.vortigo.pokemonfinder.R
import com.vortigo.pokemonfinder.domain.model.Trainer
import com.vortigo.pokemonfinder.domain.model.Type
import com.vortigo.pokemonfinder.ui.base.BaseActivity

import kotlinx.android.synthetic.main.activity_select_pokemon.*

/**
 * @author rorogarcete
 * @version 0.0.1
 * Activity to select favorite pokemon
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class SelectPokemonActivity: BaseActivity(), TrainerContract.TrainerView {

    private lateinit var trainerPresenter: TrainerContract.TrainerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_pokemon)

        trainerPresenter = TrainerPresenter(this)

        trainerPresenter.getTypes()

        img_register_trainer.setOnClickListener {
            save()
        }
    }

    override fun goToHome() {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun onEntityError(error: String) {

    }

    override fun loadTypes(types: List<Type>) {

    }

    private fun save() {
        val type = Type("name", "Image")
        val t = Trainer("Dev", type)

        trainerPresenter.saveTrainer(t)
    }


}
