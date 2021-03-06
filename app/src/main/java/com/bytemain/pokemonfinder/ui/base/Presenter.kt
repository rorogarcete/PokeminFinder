package com.bytemain.pokemonfinder.ui.base

/**
 * @author rorogarcete
 * @version 0.0.1
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 * Copyright 2019 Bytemain Inc. All rights reserved
 */
interface Presenter<View> {
    fun attachView(t: View)
    fun detachView()
}
