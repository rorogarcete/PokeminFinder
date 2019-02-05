package com.vortigo.pokemonfinder.data.mapper

interface Mapper<E, D> {
    fun toPresenter(model: E): D
    fun fromPresenter(table: D): E
}
