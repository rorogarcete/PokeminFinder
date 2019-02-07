package com.vortigo.pokemonfinder.ui.trainer

import com.vortigo.pokemonfinder.models.Trainer
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contracto for [SelectPokemonActivity]
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
interface TrainerContract {
    interface TrainerView: View  {
        fun goToHome(type: String)
        fun loadTypes(types: List<Type>)
    }

    interface TrainerPresenter: Presenter<TrainerView> {
        fun saveTrainer(trainer: Trainer)
        fun getTypes()
    }
}