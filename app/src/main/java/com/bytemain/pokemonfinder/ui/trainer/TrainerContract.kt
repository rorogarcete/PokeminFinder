package com.bytemain.pokemonfinder.ui.trainer

import com.bytemain.pokemonfinder.models.Trainer
import com.bytemain.pokemonfinder.models.Type
import com.bytemain.pokemonfinder.ui.base.Presenter
import com.bytemain.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contracto for [SelectPokemonActivity]
 * Copyright 2019 Bytemain Inc. All rights reserved
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