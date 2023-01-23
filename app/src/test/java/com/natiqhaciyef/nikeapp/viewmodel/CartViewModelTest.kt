package com.natiqhaciyef.nikeapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.natiqhaciyef.artapptesting.util.MainCoroutineRule
import com.natiqhaciyef.artapptesting.util.getOrAwaitValue
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.Status
import com.natiqhaciyef.nikeapp.presentation.viewmodel.CartViewModel
import com.natiqhaciyef.nikeapp.repo.FakeCartRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CartViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: CartViewModel

    @Before
    fun setup(){
        // Test doubles
        viewModel = CartViewModel(FakeCartRepository())
    }

    @Test
    fun `delete saved post id with 0 number to the cart returns error`(){
        viewModel.deleteFromCart(CartPost(0, " ", " ", " ", " ", " ", " "))
        val data = viewModel.deleteMessageString.getOrAwaitValue()
        assertThat(data.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `delete saved post id with number to the cart returns success`(){
        viewModel.deleteFromCart(CartPost(1, " ", " ", " ", " ", " ", " "))
        val data = viewModel.deleteMessageString.getOrAwaitValue()
        assertThat(data.status).isEqualTo(Status.SUCCESS)
    }
}