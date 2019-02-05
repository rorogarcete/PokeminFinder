package com.vortigo.pokemonfinder.data

import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Trainer
import com.vortigo.pokemonfinder.models.Type
import io.reactivex.Completable
import io.reactivex.Observable

interface DataSource {
    fun getTypes(): Observable<List<Type>>

    fun getPokemonsByType(name: Type): Observable<List<Pokemon>>

    fun getPokemonsByFilter(query: String): Observable<List<Pokemon>>

    fun saveTrainer(trainer: Trainer): Completable

    fun getTypePokemonFavorite(): Observable<List<Trainer>>
}