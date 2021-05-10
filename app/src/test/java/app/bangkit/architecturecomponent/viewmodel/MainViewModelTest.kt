package app.bangkit.architecturecomponent.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import app.bangkit.architecturecomponent.utils.TestDispatcher
import app.bangkit.architecturecomponent.model.GetVolumeModel
import app.bangkit.architecturecomponent.presentation.MainViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule val instantExecutorRule = InstantTaskExecutorRule()

    private val result: Observer<Double> = mockk(relaxed = true)
    private val model: GetVolumeModel = mockk(relaxed = true)

    private val viewModel = MainViewModel(model, TestDispatcher())

    @Before
    fun setUp() {
        viewModel.result.observeForever(result)
    }

    @Test
    fun `it should be execute the calculate properly`() {
        val expectedValue = 123.0

        every {
            model.getVolume(any(), any(), any())
        } returns expectedValue

        viewModel.calculate(0.0, 0.0, 0.0)

        assert(viewModel.result.value == expectedValue)
    }

}