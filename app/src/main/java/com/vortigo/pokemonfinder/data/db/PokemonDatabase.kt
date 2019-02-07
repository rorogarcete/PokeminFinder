package com.vortigo.pokemonfinder.data.db

import com.vicpin.krealmextensions.*
import com.vortigo.pokemonfinder.data.DataSource
import com.vortigo.pokemonfinder.data.mapper.PokemonMapper
import com.vortigo.pokemonfinder.data.mapper.TrainerMapper
import com.vortigo.pokemonfinder.data.mapper.TypeMapper
import com.vortigo.pokemonfinder.data.model.PokemonTable
import com.vortigo.pokemonfinder.data.model.TrainerTable
import com.vortigo.pokemonfinder.data.model.TypeTable
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Trainer
import com.vortigo.pokemonfinder.models.Type
import io.reactivex.Observable
import io.realm.Sort

/**
 * @author rorogarcete
 * @version 0.0.1
 * Implementation of [DataSource] for retrieve data of the Realm Database
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonDatabase: DataSource {

    override fun getTypes(): Observable<List<Type>> {
        val types = TypeTable().queryAllAsFlowable()

        return types.map {
            it.map {
                TypeMapper.toPresenter(it)
            }
        }.toObservable()
    }

    override fun getPokemonsByType(type: String): Observable<List<Pokemon>> {
        val pokemons = PokemonTable().querySortedAsFlowable(FIELD_NAME, Sort.ASCENDING)
        { equalTo(FIELD_TYPE_NAME, type) }

        return  pokemons.map {
            it.map {
                PokemonMapper.toPresenter(it)
            }
        }.toObservable()
    }

    override fun getPokemonsByFilter(query: String): Observable<List<Pokemon>> {
        val pokemons = PokemonTable().querySortedAsFlowable(FIELD_NAME, Sort.ASCENDING)
        { contains(FIELD_NAME, query) }

        return  pokemons.map {
            it.map {
                PokemonMapper.toPresenter(it)
            }
        }.toObservable()
    }

    override fun saveTrainer(trainer: Trainer) {
        val trainerTable = TrainerMapper.fromPresenter(trainer)
        trainerTable.save()
    }

    override fun getTypePokemonFavorite(): Observable<List<Trainer>> {
        val typeFavorites = TrainerTable().queryAllAsFlowable()

        return typeFavorites.map {
            it.map {
                TrainerMapper.toPresenter(it)
            }
        }.toObservable()
    }

    companion object {
        val FIELD_NAME = "name"
        val FIELD_TYPE_NAME = "type.name"
    }

}