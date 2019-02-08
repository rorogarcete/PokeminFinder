package com.vortigo.pokemonfinder.presenters

import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.vortigo.pokemonfinder.data.DataSource
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchContract
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchPresenter
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.lang.Exception

class PokemonSearchPresenterTest {

    @Mock
    lateinit var dataSource: DataSource

    @Mock
    lateinit var view: PokemonSearchContract.PokemonSearchView

    lateinit var presenter: PokemonSearchContract.PokemonSerchPresenter

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PokemonSearchPresenter(dataSource, Schedulers.trampoline(), Schedulers.trampoline())
        presenter.attachView(view)
    }

    @Test
    fun loadPokemonsByFilter() {
        val pokemons = getDummyList()
        val query = "Bulbasaur"
        var error = "error"

        Mockito.`when`(dataSource.getPokemonsByFilter(query)).thenReturn(Observable.fromArray(pokemons))

        presenter.getPokemonsByFilter(query)

        verify(view).showProgress()
        verify(view).loadPokemons(pokemons)
        verify(view, never()).onEntityError(error)
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