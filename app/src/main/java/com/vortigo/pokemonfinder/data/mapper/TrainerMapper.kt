package com.vortigo.pokemonfinder.data.mapper

import com.vortigo.pokemonfinder.data.model.TrainerTable
import com.vortigo.pokemonfinder.data.model.TypeTable
import com.vortigo.pokemonfinder.models.Trainer
import com.vortigo.pokemonfinder.models.Type
import io.realm.RealmList

object TrainerMapper: Mapper<TrainerTable, Trainer> {

    override fun toPresenter(table: TrainerTable): Trainer {
        return Trainer(
            table.name,
            table.typePokemonFavorite as Type
        )

    }

    override fun fromPresenter(model: Trainer): TrainerTable {
        return TrainerTable(
            model.name,
            model.typePokemon as RealmList<TypeTable>
        )

    }

}