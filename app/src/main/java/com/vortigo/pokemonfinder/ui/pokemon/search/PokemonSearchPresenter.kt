package com.vortigo.pokemonfinder.ui.pokemon.search

import com.vortigo.pokemonfinder.data.DataSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PokemonSearchPresenter @Inject constructor(
    var dataSource: DataSource,
    val subscriberScheduler : Scheduler = Schedulers.io(),
    val observerScheduler : Scheduler = AndroidSchedulers.mainThread()): PokemonSearchContract.PokemonSerchPresenter {

    private lateinit var view: PokemonSearchContract.PokemonSearchView

    private val subscriptions = CompositeDisposable()

    override fun attachView(t: PokemonSearchContract.PokemonSearchView) {
        view = t
    }

    override fun detachView() {
        subscriptions.clear()
    }

    override fun getPokemonsByName(name: String) {
        dataSource.getPokemonsByFilter(name)
    }


}