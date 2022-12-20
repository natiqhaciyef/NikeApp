package com.natiqhaciyef.nikeapp.data.datasource

import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.room.NikeDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppDataSource(private var dao: NikeDao) {

    suspend fun getAllCart(): List<CartPost> = withContext(Dispatchers.IO){ dao.getAllCart() }

    suspend fun insertToCart(cartPost: CartPost) = dao.insertToCart(cartPost)

    suspend fun updateCart(cartPost: CartPost) = dao.updateCart(cartPost)

    suspend fun deleteFromCart(cartPost: CartPost) = dao.deleteFromCart(cartPost)
}