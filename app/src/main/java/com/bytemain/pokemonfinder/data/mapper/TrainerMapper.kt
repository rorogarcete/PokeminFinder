package com.bytemain.pokemonfinder.data.mapper

import com.bytemain.pokemonfinder.data.model.TrainerTable
import com.bytemain.pokemonfinder.models.Trainer

/**
 * @author rorogarcete
 * @version 0.0.1
 * Implementation of [Mapper] for model Trainer
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
object TrainerMapper: Mapper<TrainerTable, Trainer> {

    override fun toPresenter(table: TrainerTable): Trainer {
        return Trainer(
            table.name,
            table.typePokemonFavorite,
            table.typeImageUrl
        )

    }

    override fun fromPresenter(model: Trainer): TrainerTable {
        return TrainerTable(
            model.name,
            model.typePokemon,
            model.typeImageUrl
        )

    }

}