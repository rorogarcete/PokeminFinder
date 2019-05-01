package com.bytemain.pokemonfinder.ui.pokemon.types

import com.bytemain.pokemonfinder.models.Type
import com.bytemain.pokemonfinder.ui.base.Presenter
import com.bytemain.pokemonfinder.ui.base.View

/**
 * @author rorogarcete
 * @version 0.0.1
 * Contract for [TypeFragment]
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
interface TypeContract {
    interface TypeView: View {
        fun loadTypes(types: List<Type>)
    }

    interface TypePresenter: Presenter<TypeView> {
        fun getFavoriteTypes()
    }
}