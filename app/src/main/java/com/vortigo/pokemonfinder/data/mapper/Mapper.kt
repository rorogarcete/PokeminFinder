package com.vortigo.pokemonfinder.data.mapper

/**
 * @author rorogarcete
 * @version 0.0.1
 * Mapper base for convert data type for Presenter and Repository
 * Copyright 2019 Vortigo Inc. All rights reserved
 */
interface Mapper<E, D> {
    fun toPresenter(model: E): D
    fun fromPresenter(table: D): E
}
