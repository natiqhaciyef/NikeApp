package com.natiqhaciyef.nikeapp.data.repository

import com.natiqhaciyef.nikeapp.data.model.SavedModel

interface SavedInterface {
    suspend fun getAllSaved(): List<SavedModel>

    suspend fun insertToSaved(savedModel: SavedModel)

    suspend fun deleteFromSaved(savedModel: SavedModel)

}