package com.natiqhaciyef.nikeapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.natiqhaciyef.nikeapp.data.model.CartPost

@Database(entities = [CartPost::class], version = 1)
abstract class NikeDatabase : RoomDatabase(){
    abstract fun getDao(): NikeDao
}