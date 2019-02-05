package com.vortigo.pokemonfinder.data.mapper

import com.vortigo.pokemonfinder.data.model.TypeTable
import com.vortigo.pokemonfinder.models.Type

object TypeMapper: Mapper<TypeTable, Type> {

    override fun toPresenter(table: TypeTable): Type {
        return Type(
            table.name,
            table.thumbnailImage
        )

    }

    override fun fromPresenter(model: Type): TypeTable {
        return TypeTable(
            model.name,
            model.thumbnailImage
        )

    }

}