package com.natiqhaciyef.nikeapp.data.room

import androidx.room.*
import com.natiqhaciyef.nikeapp.data.model.CartPost

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_model")
    suspend fun getAllCart(): List<CartPost>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToCart(cartPost: CartPost)

    @Update
    suspend fun updateCart(cartPost: CartPost)

    @Delete
    suspend fun deleteFromCart(cartPost: CartPost)
}
