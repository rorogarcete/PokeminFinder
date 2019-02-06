package com.vortigo.pokemonfinder.data.db

import android.util.Log
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
        val pokemons = PokemonTable().querySortedAsFlowable("name", Sort.ASCENDING)
        { equalTo("type.name", type) }

        return  pokemons.map {
            it.map {
                PokemonMapper.toPresenter(it)
            }
        }.toObservable()
    }

    override fun getPokemonsByFilter(query: String): Observable<List<Pokemon>> {
        val pokemons = PokemonTable().querySortedAsFlowable("name", Sort.ASCENDING)
        { equalTo("name", query) }

        return  pokemons.map {
            it.map {
                PokemonMapper.toPresenter(it)
            }
        }.toObservable()
    }

    // TODO Change for Completable
    override fun saveTrainer(trainer: Trainer) {
        val trainerTable = TrainerMapper.fromPresenter(trainer)
        trainerTable.save()
    }

    // TODO Change query for get one Trainer
    override fun getTrainer(): Observable<Trainer> {
        val trainer = TrainerTable().queryAllAsFlowable()

        return trainer.map {
                TrainerMapper.toPresenter(it.get(0))
        }.toObservable()
    }

    override fun getTypePokemonFavorite(): Observable<List<Trainer>> {
        val typeFavorites = TrainerTable().queryAllAsFlowable()

        return typeFavorites.map {
            it.map {
                TrainerMapper.toPresenter(it)
            }
        }.toObservable()
    }

}