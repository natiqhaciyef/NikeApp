package com.natiqhaciyef.nikeapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.natiqhaciyef.artapptesting.util.MainCoroutineRule
import com.natiqhaciyef.artapptesting.util.getOrAwaitValue
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.model.Status
import com.natiqhaciyef.nikeapp.presentation.viewmodel.SavedViewModel
import com.natiqhaciyef.nikeapp.repo.FakeSavedRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SavedViewModelTest {
    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get: Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: SavedViewModel

    @Before
    fun setup() {
        viewModel = SavedViewModel(FakeSavedRepository())
    }

    @Test
    fun `delete id is equals 0 returns error`() {
        viewModel.deleteFromSaved(
            savedModel = SavedModel(
                id = 0,
                "Aj",
                "Something",
                "Something2",
                "999",
                "basketball",
                "Red"
            ))
        val result = viewModel.deleteMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `delete price is empty returns error`() {
        viewModel.deleteFromSaved(
            savedModel = SavedModel(
                id = 1,
                "Aj",
                "Something",
                "Something2",
                "",
                "basketball",
                "Red"
            ))
        val result = viewModel.deleteMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `delete function returns success`() {
        viewModel.deleteFromSaved(
            savedModel = SavedModel(
                id = 1,
                "Aj",
                "Something",
                "Something2",
                "777",
                "basketball",
                "Red"
            ))
        val result = viewModel.deleteMessageString.getOrAwaitValue()
        assertThat(result.status).isEqualTo(Status.SUCCESS)
    }
}