package com.natiqhaciyef.nikeapp.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.natiqhaciyef.nikeapp.data.datasource.AppDataSource
import com.natiqhaciyef.nikeapp.data.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDataSource() = AppDataSource()

    @Provides
    @Singleton
    fun provideRepository(ds: AppDataSource) = AppRepository(ds)
}