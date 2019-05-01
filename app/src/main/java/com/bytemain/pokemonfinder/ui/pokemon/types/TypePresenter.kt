package com.bytemain.pokemonfinder.ui.pokemon.types

import com.bytemain.pokemonfinder.data.DataSource
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
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
class TypePresenter @Inject constructor(
    var dataSource: DataSource,
    val subscriberScheduler : Scheduler = Schedulers.io(),
    val observerScheduler : Scheduler = AndroidSchedulers.mainThread()): TypeContract.TypePresenter {

    private lateinit var view: TypeContract.TypeView

    private val subscriptions = CompositeDisposable()

    override fun attachView(t: TypeContract.TypeView) {
        this.view = t
    }

    override fun detachView() {
        subscriptions.clear()
    }

    override fun getFavoriteTypes() {
        view.showProgress()
        val subscr = dataSource.getTypes()
            .subscribeOn(subscriberScheduler)
            .observeOn(observerScheduler)
            .subscribe(
                { types ->
                    view.loadTypes(types)
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