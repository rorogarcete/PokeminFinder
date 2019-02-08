package com.vortigo.pokemonfinder.ui.pokemon.list

import com.vortigo.pokemonfinder.data.DataSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * @author rorogarcete
 * @version 0.0.1
 * Presenter class of MVP Architecture
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
class PokemonListPresenter @Inject constructor(
    var dataSource: DataSource,
    val subscriberScheduler : Scheduler = Schedulers.io(),
    val observerScheduler : Scheduler = AndroidSchedulers.mainThread()): PokemonListContract.PokemonPresenter {

    private lateinit var view: PokemonListContract.PokemonView

    private val subscriptions = CompositeDisposable()

    override fun attachView(t: PokemonListContract.PokemonView) {
        view = t
    }

    override fun detachView() {
        subscriptions.clear()
    }

    /**
     * Get Pokemons selected to trainer
     */
    override fun getPokemonsFavoriteByType(type: String) {
        view.showProgress()
        val subscr = dataSource.getPokemonsByType(type)
            .subscribeOn(subscriberScheduler)
            .observeOn(observerScheduler)
            .subscribe(
                { pokemons ->
                    view.loadPokemons(pokemons)
                    view.hideProgress()
                },
                { throwable ->
                    Timber.e(throwable)
                    view.hideProgress()
                },
                {
                    view.hideProgress()
                }
            )

        subscriptions.add(subscr)
    }

    override fun makeOrderedPokemonByName(type: String) {
        view.showProgress()
        val subscr = dataSource.getPokemonsOrderedByType(type)
            .subscribeOn(subscriberScheduler)
            .observeOn(observerScheduler)
            .subscribe(
                { pokemons ->
                    view.loadPokemons(pokemons)
                    view.hideProgress()
                },
                { throwable ->
                    Timber.e(throwable)
                    view.hideProgress()
                },
                {
                    view.hideProgress()
                }
            )

        subscriptions.add(subscr)
    }

}