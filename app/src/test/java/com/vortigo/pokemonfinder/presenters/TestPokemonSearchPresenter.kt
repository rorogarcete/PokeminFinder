package com.vortigo.pokemonfinder.presenters

import com.vortigo.pokemonfinder.data.DataSource
import com.vortigo.pokemonfinder.models.Pokemon
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchContract
import com.vortigo.pokemonfinder.ui.pokemon.search.PokemonSearchPresenter
import com.vortigo.pokemonfinder.ui.pokemon.types.TypeContract
import com.vortigo.pokemonfinder.ui.pokemon.types.TypePresenter
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.Exception

class TestPokemonSearchPresenter {

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

        dataSource.getPokemonsByFilter("Bulbasaur")
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