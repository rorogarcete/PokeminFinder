package com.vortigo.pokemonfinder.data.mapper

import com.vortigo.pokemonfinder.data.model.TrainerTable
import com.vortigo.pokemonfinder.models.Trainer

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