package com.vortigo.pokemonfinder.presenters

import com.vortigo.pokemonfinder.data.DataSource
import com.vortigo.pokemonfinder.models.Type
import com.vortigo.pokemonfinder.ui.pokemon.types.TypeContract
import com.vortigo.pokemonfinder.ui.pokemon.types.TypePresenter
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.Exception

class TestTypePresenter {

    @Mock
    lateinit var dataSource: DataSource

    @Mock
    lateinit var view: TypeContract.TypeView

    lateinit var presenter: TypeContract.TypePresenter

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TypePresenter(dataSource, Schedulers.trampoline(), Schedulers.trampoline())
        presenter.attachView(view)
    }

    @Test
    fun loadTypes() {
        val types = getDummyList()

        dataSource.getTypes()
    }

    fun getDummyList(): List<Type> {
        return listOf(
            Type( "Fire", "/pokemons/fire"),
            Type( "Water", "/pokemons/water"),
            Type( "Normal", "/pokemons/normal")
        )
    }
    
}