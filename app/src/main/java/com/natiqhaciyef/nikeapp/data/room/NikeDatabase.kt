package com.natiqhaciyef.nikeapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel

@Database(entities = [CartPost::class, SavedModel::class], version = 2)
abstract class NikeDatabase : RoomDatabase(){
    abstract fun getCartDao(): CartDao
    abstract fun getSavedDao(): SavedDao
}