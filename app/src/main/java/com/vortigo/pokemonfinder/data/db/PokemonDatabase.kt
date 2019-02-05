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

class PokemonDatabase: DataSource {

    override fun getTypes(): Observable<List<Type>> {
        val types = TypeTable().queryAllAsFlowable()

        return types.map {
            it.map {
                TypeMapper.toPresenter(it)
            }
        }.toObservable()
    }

    // TODO add filter by type
    override fun getPokemonsByType(name: Type): Observable<List<Pokemon>> {
        val pokemons = PokemonTable().querySortedAsFlowable("name", Sort.DESCENDING)

        return  pokemons.map {
            it.map {
                PokemonMapper.toPresenter(it)
            }
        }.toObservable()
    }

    override fun getPokemonsByFilter(query: String): Observable<List<Pokemon>> {
        val pokemons = PokemonTable().queryAsFlowable {
            equalTo("name", query)
        }

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

}