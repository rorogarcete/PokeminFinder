package com.bytemain.pokemonfinder.presenters

import com.nhaarman.mockito_kotlin.verify
import com.bytemain.pokemonfinder.data.DataSource
import com.bytemain.pokemonfinder.models.Trainer
import com.bytemain.pokemonfinder.ui.trainer.TrainerContract
import com.bytemain.pokemonfinder.ui.trainer.TrainerPresenter
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.lang.Exception

class TrainerPresenterTest {

    @Mock
    lateinit var dataSource: DataSource

    @Mock
    lateinit var view: TrainerContract.TrainerView

    lateinit var presenter: TrainerContract.TrainerPresenter

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TrainerPresenter(dataSource, Schedulers.trampoline(), Schedulers.trampoline())
        presenter.attachView(view)
    }

    @Test
    fun saveTrainer() {
        val trainer = getTrainerMock()
        val type = "normal"

        Mockito.`when`(dataSource.saveTrainer(trainer)).thenReturn(true)

        presenter.saveTrainer(trainer)

        verify(view).goToHome(type)
    }

    fun getTrainerMock(): Trainer {
        return Trainer("Dev", "normal", "ImageUrl")
    }

}