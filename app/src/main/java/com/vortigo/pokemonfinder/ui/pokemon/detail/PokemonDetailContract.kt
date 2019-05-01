package com.vortigo.pokemonfinder.ui.pokemon.detail

import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.ui.base.Presenter
import com.vortigo.pokemonfinder.ui.base.View
import io.reactivex.Observable

interface PokemonDetailContract {

    interface DetailView: View {
        fun loadPokemon(pokemon: Pokemon)
    }

    interface DetailPresenter: Presenter<DetailView> {
        //fun getDetailById(id: Int): Observable<Pokemon>
    }

}