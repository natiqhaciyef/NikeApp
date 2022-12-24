package com.natiqhaciyef.nikeapp.data.room

import androidx.room.*
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel

@Dao
interface SavedDao {
    @Query("SELECT * FROM saved_model")
    suspend fun getAllSaved(): List<SavedModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToCart(savedModel: SavedModel)

    @Update
    suspend fun updateCart(savedModel: SavedModel)

    @Delete
    suspend fun deleteFromCart(savedModel: SavedModel)
}