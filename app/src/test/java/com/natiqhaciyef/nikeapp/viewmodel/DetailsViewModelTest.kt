package com.natiqhaciyef.nikeapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.natiqhaciyef.artapptesting.util.MainCoroutineRule
import com.natiqhaciyef.artapptesting.util.getOrAwaitValue
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.model.Status
import com.natiqhaciyef.nikeapp.presentation.viewmodel.DetailsViewModel
import com.natiqhaciyef.nikeapp.repo.FakeCartRepository
import com.natiqhaciyef.nikeapp.repo.FakeSavedRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: DetailsViewModel

    @Before
    fun setup() {
        viewModel = DetailsViewModel(FakeCartRepository(), FakeSavedRepository())
    }

    @Test
    fun `insert cart id different from 0 returns error`() {
        viewModel.insertToCart(CartPost(1, "Air Jordan", "donao", "donao1", "22.3", "basketball", "Red"))
        val result = viewModel.insertCartMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert cart name empty returns error`() {
        viewModel.insertToCart(CartPost(0, "", "donao", "donao1", "22.3", "basketball", "Red"))
        val result = viewModel.insertCartMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert cart returns success`() {
        viewModel.insertToCart(CartPost(0, "AJ", "donao", "donao1", "22.3", "basketball", "Red"))
        val result = viewModel.insertCartMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.SUCCESS)
    }


    @Test
    fun `insert saved id different from 0 returns error`() {
        viewModel.insertToSaved(SavedModel(1, "AJ", "donao", "donao1", "22.3", "basketball", "Red"))
        val result = viewModel.insertSavedMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert saved name empty returns error`() {
        viewModel.insertToSaved(SavedModel(0, "", "donao", "donao1", "22.3", "basketball", "Red"))
        val result = viewModel.insertSavedMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert saved returns success`() {
        viewModel.insertToSaved(SavedModel(0, "AJ", "donao", "donao1", "22.3", "basketball", "Red"))
        val result = viewModel.insertSavedMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.SUCCESS)
    }
}