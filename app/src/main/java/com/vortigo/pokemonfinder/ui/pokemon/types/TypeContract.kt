package com.vortigo.pokemonfinder.ui.pokemon.types

import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contract for [TypeFragment]
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
interface TypeContract {
    interface TypeView: View {
        fun loadTypes(types: List<Type>)
    }

    interface TypePresenter: Presenter<TypeView> {
        fun getFavoriteTypes()
    }
}