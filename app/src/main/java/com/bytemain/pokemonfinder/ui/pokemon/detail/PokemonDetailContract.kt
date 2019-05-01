package com.bytemain.pokemonfinder.ui.pokemon.detail

import com.bytemain.pokemonfinder.models.Pokemon
import com.bytemain.pokemonfinder.ui.base.Presenter
import com.bytemain.pokemonfinder.ui.base.View

interface PokemonDetailContract {

    interface DetailView: View {
        fun loadPokemon(pokemon: Pokemon)
    }

    interface DetailPresenter: Presenter<DetailView> {
        //fun getDetailById(id: Int): Observable<Pokemon>
    }

}