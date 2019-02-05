package com.vortigo.pokemonfinder.data

import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Trainer
import com.vortigo.pokemonfinder.models.Type
import io.reactivex.Observable

interface DataSource {
    fun getTypes(): Observable<List<Type>>

    fun getPokemonsByType(type: String): Observable<List<Pokemon>>

    fun getPokemonsByFilter(query: String): Observable<List<Pokemon>>

    fun saveTrainer(trainer: Trainer)

    fun getTypePokemonFavorite(): Observable<List<Trainer>>
}