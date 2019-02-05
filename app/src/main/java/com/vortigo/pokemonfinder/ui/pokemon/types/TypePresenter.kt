package com.vortigo.pokemonfinder.ui.pokemon.types

import com.vortigo.pokemonfinder.data.DataSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

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

    }

}