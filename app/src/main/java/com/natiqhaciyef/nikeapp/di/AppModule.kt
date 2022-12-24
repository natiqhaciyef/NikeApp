package com.natiqhaciyef.nikeapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.natiqhaciyef.nikeapp.data.datasource.AppDataSource
import com.natiqhaciyef.nikeapp.data.repository.CartRepository
import com.natiqhaciyef.nikeapp.data.repository.SavedRepository
import com.natiqhaciyef.nikeapp.data.room.CartDao
import com.natiqhaciyef.nikeapp.data.room.NikeDatabase
import com.natiqhaciyef.nikeapp.data.room.SavedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDataSource(cartDao: CartDao, savedDao: SavedDao) = AppDataSource(cartDao, savedDao)

    @Provides
    @Singleton
    fun provideCartRepository(ds: AppDataSource) = CartRepository(ds)

    @Provides
    @Singleton
    fun provideSavedRepository(ds: AppDataSource) = SavedRepository(ds)


    @Provides
    @Singleton
    fun provideRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NikeDatabase::class.java, "nike_database")
            .build()

    @Provides
    @Singleton
    fun provideSavedDao(db: NikeDatabase) = db.getSavedDao()

    @Provides
    @Singleton
    fun provideCartDao(db: NikeDatabase) = db.getCartDao()
}