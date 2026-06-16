package com.example.vanapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.vanapp.model.Van
import com.example.vanapp.repository.VanRepository
import com.example.vanapp.viewmodel.VanViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import android.app.Application

@ExperimentalCoroutinesApi
class VanViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Mock
    private lateinit var repository: VanRepository

    @Mock
    private lateinit var observer: Observer<List<Van>>

    @Mock
    private lateinit var application: Application

    private lateinit var viewModel: VanViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = VanViewModel(application)
        viewModel.setRepository(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `carregarVans should update vans LiveData`() = runTest {
        val mockVans = listOf(Van(1, "Rota Teste", "Motorista Teste", "08:00"))
        `when`(repository.getVans()).thenReturn(mockVans)

        viewModel.vans.observeForever(observer)
        viewModel.carregarVans()

        verify(observer).onChanged(mockVans)
        assert(viewModel.vans.value == mockVans)
        
        viewModel.vans.removeObserver(observer)
    }
}