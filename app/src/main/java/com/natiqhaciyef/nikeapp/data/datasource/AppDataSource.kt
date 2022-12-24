package com.natiqhaciyef.nikeapp.data.datasource

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.room.CartDao
import com.natiqhaciyef.nikeapp.data.room.SavedDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppDataSource(private var cartDao: CartDao, private var savedDao: SavedDao) {

    suspend fun getAllCart(): List<CartPost> = withContext(Dispatchers.IO){ cartDao.getAllCart() }

    suspend fun insertToCart(cartPost: CartPost) = cartDao.insertToCart(cartPost)

    suspend fun updateCart(cartPost: CartPost) = cartDao.updateCart(cartPost)

    suspend fun deleteFromCart(cartPost: CartPost) = cartDao.deleteFromCart(cartPost)


    suspend fun getAllSaved(): List<SavedModel> = savedDao.getAllSaved()

    suspend fun insertToSaved(savedModel: SavedModel) = savedDao.insertToSaved(savedModel)

    suspend fun updateSaved(savedModel: SavedModel) = savedDao.updateSaved(savedModel)

    suspend fun deleteFromSaved(savedModel: SavedModel) = savedDao.deleteFromSaved(savedModel)
}