package com.vortigo.pokemonfinder.data.mapper

import com.vortigo.pokemonfinder.data.model.TypeTable
import com.vortigo.pokemonfinder.models.Type

/**
 * @author rorogarcete
 * @version 0.0.1
 * Implementation of [Mapper] for model Type
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
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