package com.vortigo.pokemonfinder.data.mapper

import com.vortigo.pokemonfinder.data.model.PokemonTable
import com.vortigo.pokemonfinder.data.model.TypeTable
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Type
import io.realm.RealmList

/**
 * @author rorogarcete
 * @version 0.0.1
 * Implementation of [Mapper] for model Pokemon
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
object PokemonMapper: Mapper<PokemonTable, Pokemon> {

    override fun toPresenter(table: PokemonTable): Pokemon {
        return Pokemon(
            table.id,
            //table.abilities.toTypedArray(),
            table.detailPageURL,
            table.weight,
            //table.weakness.toTypedArray(),
            table.number,
            table.height,
            table.collectibles_slug,
            table.featured,
            table.slug,
            table.name,
            table.thumbnailAltText,
            table.thumbnailImage,
            table.type as List<Type>
        )
    }

    override fun fromPresenter(model: Pokemon): PokemonTable {
        return PokemonTable(
            model.id,
            //model.abilities as RealmList<String>,
            model.detailPageURL,
            model.weight,
            //model.weakness  as RealmList<String>,
            model.number,
            model.height,
            model.collectibles_slug,
            model.featured,
            model.slug,
            model.name,
            model.thumbnailAltText,
            model.thumbnailImage,
            model.type as RealmList<TypeTable>
        )
    }

}