package com.natiqhaciyef.nikeapp.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.natiqhaciyef.nikeapp.data.datasource.AppDataSource
import com.natiqhaciyef.nikeapp.data.repository.AppRepository
import com.natiqhaciyef.nikeapp.data.room.NikeDao
import com.natiqhaciyef.nikeapp.data.room.NikeDatabase
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
    fun provideDataSource(dao: NikeDao) = AppDataSource(dao)

    @Provides
    @Singleton
    fun provideRepository(ds: AppDataSource) = AppRepository(ds)

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NikeDatabase::class.java, "cart_model").build().getDao()
}