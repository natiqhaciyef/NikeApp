package com.natiqhaciyef.nikeapp.data.repository

import com.natiqhaciyef.nikeapp.data.model.CartPost

interface CartInterface {
    suspend fun getAllCart(): List<CartPost>

    suspend fun insertToCart(cartPost: CartPost)

    suspend fun deleteFromCart(cartPost: CartPost)
}