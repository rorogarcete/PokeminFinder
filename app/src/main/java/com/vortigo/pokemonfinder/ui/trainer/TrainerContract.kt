package com.vortigo.pokemonfinder.ui.trainer

import com.vortigo.pokemonfinder.models.Trainer
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

interface TrainerContract {

    interface TrainerView: View  {
        fun goToHome()
        fun loadTypes(types: List<Type>)
    }

    interface TrainerPresenter: Presenter<TrainerView> {
        fun saveTrainer(trainer: Trainer)
        fun getTypes()
    }

}