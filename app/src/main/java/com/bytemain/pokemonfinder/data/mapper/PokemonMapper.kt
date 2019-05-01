package com.bytemain.pokemonfinder.data.mapper

import com.bytemain.pokemonfinder.data.model.PokemonTable
import com.bytemain.pokemonfinder.data.model.TypeTable
import com.bytemain.pokemonfinder.models.Pokemon
import com.bytemain.pokemonfinder.models.Type
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
            table.detailPageURL,
            table.weight,
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
            model.detailPageURL,
            model.weight,
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