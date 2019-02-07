package com.vortigo.pokemonfinder.presenters

import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.vortigo.pokemonfinder.data.DataSource
import com.vortigo.pokemonfinder.models.Trainer
import com.vortigo.pokemonfinder.ui.trainer.TrainerContract
import com.vortigo.pokemonfinder.ui.trainer.TrainerPresenter
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

        Mockito.`when`(dataSource.saveTrainer(trainer)).thenReturn(true)

        verify(view).showProgress()
        verify(view).goToHome("normal")
        verify(view, never()).onEntityError("Error")
    }

    fun getTrainerMock(): Trainer {
        return Trainer("Dev", "normal", "ImageUrl")
    }

}