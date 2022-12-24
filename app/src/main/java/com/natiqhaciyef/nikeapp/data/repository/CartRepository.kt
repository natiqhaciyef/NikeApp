package com.natiqhaciyef.nikeapp.data.repository

import com.natiqhaciyef.nikeapp.data.datasource.AppDataSource
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel

class CartRepository (var dataSource: AppDataSource) {

    suspend fun getAllCart(): List<CartPost> = dataSource.getAllCart()

    suspend fun insertToCart(cartPost: CartPost) = dataSource.insertToCart(cartPost)

    suspend fun updateCart(cartPost: CartPost) = dataSource.updateCart(cartPost)

    suspend fun deleteFromCart(cartPost: CartPost) = dataSource.deleteFromCart(cartPost)

}