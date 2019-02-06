package com.vortigo.pokemonfinder.data.mapper

import com.vortigo.pokemonfinder.data.model.PokemonTable
import com.vortigo.pokemonfinder.models.Pokemon
import io.realm.RealmList

object PokemonMapper: Mapper<PokemonTable, Pokemon> {

    override fun toPresenter(table: PokemonTable): Pokemon {
        return Pokemon(
            table.id,
            table.abilities.toTypedArray(),
            table.detailPageURL,
            table.weight,
            table.weakness.toTypedArray(),
            table.number,
            table.height,
            table.collectibles_slug,
            table.featured,
            table.slug,
            table.name,
            table.thumbnailAltText,
            table.thumbnailImage,
            table.type.toTypedArray()
        )

    }

    override fun fromPresenter(model: Pokemon): PokemonTable {
        return PokemonTable(
            model.id,
            model.abilities as RealmList<String>,
            model.detailPageURL,
            model.weight,
            model.weakness  as RealmList<String>,
            model.number,
            model.height,
            model.collectibles_slug,
            model.featured,
            model.slug,
            model.name,
            model.thumbnailAltText,
            model.thumbnailImage,
            model.type as RealmList<String>
        )

    }

}