package com.vortigo.pokemonfinder.ui.pokemon.types

import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View

interface TypeContract {

    interface TypeView: View {
        fun loadTypes(types: List<Type>)
    }

    interface TypePresenter: Presenter<TypeView> {
        fun getFavoriteTypes()
    }

}