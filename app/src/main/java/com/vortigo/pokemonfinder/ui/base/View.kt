package com.vortigo.pokemonfinder.ui.base

/**
 * @author rorogarcete
 * @version 0.0.1
 * Interface base for view of the pattern MVP
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
interface View {
    fun showProgress()
    fun hideProgress()
    fun onEntityError(error: String)
}
