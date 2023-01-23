package com.natiqhaciyef.nikeapp.repo

import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.repository.SavedInterface

class FakeSavedRepository : SavedInterface {
    private val list = mutableListOf<SavedModel>()

    override suspend fun getAllSaved(): List<SavedModel> {
        return list
    }

    override suspend fun insertToSaved(savedModel: SavedModel) {
        list.add(savedModel)
    }

    override suspend fun deleteFromSaved(savedModel: SavedModel) {
        list.remove(savedModel)
    }
}