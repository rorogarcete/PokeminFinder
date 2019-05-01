package com.bytemain.pokemonfinder.ui.pokemon.detail

import com.bytemain.pokemonfinder.data.DataSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PokemonDetailPresenter @Inject constructor(
    val dataSource: DataSource,
    val subscriberScheduler: Scheduler = Schedulers.io(),
    val observerScheduler: Scheduler = AndroidSchedulers.mainThread()
) : PokemonDetailContract.DetailPresenter {

    private lateinit var view: PokemonDetailContract.DetailView

    private val subscriptions = CompositeDisposable()


    override fun attachView(t: PokemonDetailContract.DetailView) {
        this.view = t
    }

    override fun detachView() {
        subscriptions.clear()
    }

//    override fun getDetailById(id: Int): Observable<Pokemon> {
//        view.showProgress()
//        val subscr = dataSource.getPokemonDetailById(id)
//            .subscribeOn(subscriberScheduler)
//            .observeOn(observerScheduler)
//            .subscribe(
//                { pokemons ->
//                    view.loadPokemon(pokemons)
//                    view.hideProgress()
//                },
//                { throwable ->
//                    Timber.e(throwable)
//                    view.hideProgress()
//                },
//                {
//                    view.hideProgress()
//                }
//            )
//
//        subscriptions.add(subscr)
//
//    }


}