package com.natiqhaciyef.nikeapp.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.natiqhaciyef.nikeapp.launchFragmentInHiltContainer
import com.natiqhaciyef.nikeapp.presentation.view.fragment.home.HomeFragment
import com.natiqhaciyef.nikeapp.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.presentation.adapter.PostAdapter
import com.natiqhaciyef.nikeapp.presentation.view.fragment.home.HomeFragmentDirections

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class HomeFragmentTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun clickPostAction(){
        val navController = Mockito.mock(NavController::class.java)
        val post = PostModel(name = "AJ","1234","1234.png","79.90","basketball", listOf("Red"))
        launchFragmentInHiltContainer<HomeFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }
        Espresso.onView(ViewMatchers.withId(R.id.postRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<PostAdapter.PostHolder>(0, ViewActions.click())
        )
        Mockito.verify(navController).navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(post))

    }

}