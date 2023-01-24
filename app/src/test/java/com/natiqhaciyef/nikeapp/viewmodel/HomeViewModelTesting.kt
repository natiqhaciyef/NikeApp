package com.natiqhaciyef.nikeapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.natiqhaciyef.artapptesting.util.MainCoroutineRule
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTesting {
    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get: Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var list: MutableList<PostModel>

    @Before
    fun setup(){
        list = mutableListOf(
            PostModel(name = "1", " ", " ", " ", "casual", listOf()),
            PostModel(name = "2", " ", " ", " ", "basketball", listOf()),
            PostModel(name = "3", " ", " ", " ", "basketball", listOf()),
            PostModel(name = "4", " ", " ", " ", "running", listOf()),
        )
    }

    fun categoryFilter(category: String, list: MutableList<PostModel>): MutableList<PostModel> {
        var customList = mutableListOf<PostModel>()
        if (category.lowercase() != "all" && category.isNotEmpty() && category.lowercase() != "" && category.lowercase() != "bütün") {
            if (category.lowercase() == "running" || category.lowercase() == "qaçış") {
                for (element in list) {
                    if (element.category.lowercase() == "running")
                        customList.add(element)
                }
            } else if (category.lowercase() == "sneaker" || category.lowercase() == "idman") {
                for (element in list) {
                    if (element.category.lowercase() == "sneaker")
                        customList.add(element)
                }
            } else if (category.lowercase() == "basketball" || category.lowercase() == "basketbol") {
                for (element in list) {
                    if (element.category.lowercase() == "basketball")
                        customList.add(element)
                }
            } else if (category.lowercase() == "casual" || category.lowercase() == "gündəlik") {
                for (element in list) {
                    if (element.category.lowercase() == "casual")
                        customList.add(element)
                }
            }
        } else {
            customList = list
        }

        return customList
    }

    @Test
    fun `category filtering by basketball returns success`(){
        val result = categoryFilter("basketball", list)
        assertThat(result).isEqualTo(mutableListOf(
            PostModel(name = "2", " ", " ", " ", "basketball", listOf()),
            PostModel(name = "3", " ", " ", " ", "basketball", listOf()),
            ))
    }
}