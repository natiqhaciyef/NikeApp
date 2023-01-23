package com.natiqhaciyef.nikeapp.repo

import androidx.lifecycle.MutableLiveData
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.repository.CartInterface
import com.natiqhaciyef.nikeapp.data.repository.CartRepository

class FakeCartRepository : CartInterface {
    private val cartPosts = arrayListOf<CartPost>()

    override suspend fun getAllCart(): List<CartPost> {
        return cartPosts
    }

    override suspend fun insertToCart(cartPost: CartPost) {
        cartPosts.add(cartPost)
    }

    override suspend fun deleteFromCart(cartPost: CartPost) {
        cartPosts.remove(cartPost)
    }
}