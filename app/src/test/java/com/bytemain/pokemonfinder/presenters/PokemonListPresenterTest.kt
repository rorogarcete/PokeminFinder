package com.bytemain.pokemonfinder.presenters

import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.bytemain.pokemonfinder.data.DataSource
import com.bytemain.pokemonfinder.models.Pokemon
import com.bytemain.pokemonfinder.models.Type
import com.bytemain.pokemonfinder.ui.pokemon.list.PokemonListContract
import com.bytemain.pokemonfinder.ui.pokemon.list.PokemonListPresenter
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.lang.Exception

class PokemonListPresenterTest {

    @Mock
    lateinit var dataSource: DataSource

    @Mock
    lateinit var view: PokemonListContract.PokemonView

    lateinit var presenter: PokemonListContract.PokemonPresenter

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PokemonListPresenter(dataSource, Schedulers.trampoline(), Schedulers.trampoline())
        presenter.attachView(view)
    }

    @Test
    fun loadPokemonsByType() {
        val pokemons = getDummyList()
        val type = "normal"

        Mockito.`when`(dataSource.getPokemonsByType(type)).thenReturn(Observable.fromArray(pokemons))

        presenter.getPokemonsFavoriteByType(type)

        verify(view).showProgress()
        verify(view).loadPokemons(pokemons)
        verify(view, never()).onEntityError("Error")
    }

    fun getDummyList(): List<Pokemon> {
        return listOf(
            Pokemon( 1, "detail", 15.5, "122",
                20.5, "Bolb", "feature", "slud",
                "Bolb", "/bolb/thumbnail", "/image", getTypeList()),
            Pokemon( 1, "detail", 15.5, "122",
                20.5, "Bolb", "feature", "slud",
                "Bolb", "/bolb/thumbnail", "/image", getTypeList()),
            Pokemon( 1, "detail", 15.5, "122",
                20.5, "Bolb", "feature", "slud",
                "Bolb", "/bolb/thumbnail", "/image", getTypeList())

        )
    }

    fun getTypeList(): List<Type> {
        return listOf(
            Type( "Fire", "/pokemons/fire"),
            Type( "Water", "/pokemons/water"),
            Type( "Normal", "/pokemons/normal")
        )
    }
    
}