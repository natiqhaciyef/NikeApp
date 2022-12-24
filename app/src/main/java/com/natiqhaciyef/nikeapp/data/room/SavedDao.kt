package com.natiqhaciyef.nikeapp.data.room

import androidx.room.*
import com.natiqhaciyef.nikeapp.data.model.SavedModel

@Dao
interface SavedDao {
    @Query("SELECT * FROM saved_model")
    suspend fun getAllSaved(): List<SavedModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToSaved(savedModel: SavedModel)

    @Update
    suspend fun updateSaved(savedModel: SavedModel)

    @Delete
    suspend fun deleteFromSaved(savedModel: SavedModel)
}