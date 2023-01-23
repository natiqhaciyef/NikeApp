package com.natiqhaciyef.nikeapp.data.repository

import com.natiqhaciyef.nikeapp.data.datasource.AppDataSource
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import javax.inject.Inject

class CartRepository @Inject constructor(var dataSource: AppDataSource) : CartInterface {

    override suspend fun getAllCart(): List<CartPost> = dataSource.getAllCart()

    override suspend fun insertToCart(cartPost: CartPost) = dataSource.insertToCart(cartPost)

    override suspend fun deleteFromCart(cartPost: CartPost) = dataSource.deleteFromCart(cartPost)

}