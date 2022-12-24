package com.natiqhaciyef.nikeapp.data.datasource

import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.room.CartDao
import com.natiqhaciyef.nikeapp.data.room.SavedDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppDataSource(private var cartDao: CartDao, private var savedDao: SavedDao) {

    suspend fun getAllCart(): List<CartPost> = withContext(Dispatchers.IO){ cartDao.getAllCart() }

    suspend fun insertToCart(cartPost: CartPost) = cartDao.insertToCart(cartPost)

    suspend fun updateCart(cartPost: CartPost) = cartDao.updateCart(cartPost)

    suspend fun deleteFromCart(cartPost: CartPost) = cartDao.deleteFromCart(cartPost)
}