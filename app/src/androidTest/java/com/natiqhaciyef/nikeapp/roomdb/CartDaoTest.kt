package com.natiqhaciyef.nikeapp.roomdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.room.CartDao
import com.natiqhaciyef.nikeapp.data.room.NikeDatabase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

// During testing you have to comment shirinking and minifying in gradle module

@SmallTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
class CartDaoTest {
    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get: Rule
    var hiltRule = HiltAndroidRule(this)


    @Inject
    @Named("testDatabase")
    lateinit var database: NikeDatabase
    private lateinit var dao: CartDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.getCartDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertCartTesting() = runBlockingTest {
        val cart = CartPost(
            id = 1201,
            name = "AJ",
            image = "empty",
            imagePng = "empty.png",
            price ="71.3",
            category = "basketball",
            colors = "black"
        )
        dao.insertToCart(cart)
//        delay(1500)
        val list = dao.getAllCart()
        assertThat(list).contains(cart)
    }

    @Test
    fun deleteCartTesting() = runBlockingTest {
        val cart = CartPost(
            id = 1201,
            name = "AJ",
            image = "empty",
            imagePng = "empty.png",
            price ="71.3",
            category = "basketball",
            colors = "black"
        )
        dao.deleteFromCart(cart)
//        delay(1500)
        val list = dao.getAllCart()
        assertThat(list).doesNotContain(cart)
    }
}