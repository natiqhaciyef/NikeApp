package com.natiqhaciyef.nikeapp.di

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.natiqhaciyef.nikeapp.data.room.NikeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("testDatabase")
    fun injectInMemoryRule(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, NikeDatabase::class.java)
            .allowMainThreadQueries()
            .build()

}