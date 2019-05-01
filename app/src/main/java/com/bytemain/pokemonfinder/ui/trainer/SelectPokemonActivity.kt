package com.bytemain.pokemonfinder.ui.trainer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.bytemain.pokemonfinder.PokemonFinderApp
import com.bytemain.pokemonfinder.R
import com.bytemain.pokemonfinder.data.prefs.PokemonPreference
import com.bytemain.pokemonfinder.helper.SpinnerTypeAdapter
import com.bytemain.pokemonfinder.helper.Util
import com.bytemain.pokemonfinder.models.Trainer
import com.bytemain.pokemonfinder.models.Type
import com.bytemain.pokemonfinder.ui.base.BaseActivity
import com.bytemain.pokemonfinder.ui.pokemon.search.PokemonSearchActivity
import kotlinx.android.synthetic.main.activity_select_pokemon.*
import timber.log.Timber
import javax.inject.Inject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Activity to select favorite pokemon
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
class SelectPokemonActivity: BaseActivity(), TrainerContract.TrainerView {

    @Inject lateinit var presenter: TrainerContract.TrainerPresenter

    private lateinit var progressBar: ProgressBar

    private var trainerName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_pokemon)

        progressBar = findViewById(R.id.progress_indicator)

        img_arrow.setOnClickListener {
            onBackPressed()
        }

        setInit()
        setInjection()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.getTypes()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish(ActivityAnimation.SLIDE_RIGHT)
    }

    override fun goToHome(type: String) {
        PokemonPreference().setTypeFavorite(this, type)
        startActivity(Intent(this, PokemonSearchActivity::class.java), ActivityAnimation.SLIDE_LEFT)
        finish()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun onEntityError(error: String) {
        Timber.e(error)
    }

    override fun loadTypes(types: List<Type>) {
        val typeAdapter = SpinnerTypeAdapter(this, R.layout.spinner_item, types)
        typeAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
        spinner_types.adapter = typeAdapter
    }

    private fun save(name: String) {
        val typeFav = spinner_types.getSelectedItem() as Type
        val t = Trainer(name, typeFav.name, typeFav.thumbnailImage)
        presenter.saveTrainer(t)
    }

    private fun setInit() {
        // asign value for testing purpose
        val trainerName = intent.getStringExtra(Util.TRAINER_NAME) ?: "normal"

        img_register_trainer.setOnClickListener {
            save(trainerName)
        }
    }

    private fun setInjection() {
        PokemonFinderApp.instance.component.inject(this)
    }

}
