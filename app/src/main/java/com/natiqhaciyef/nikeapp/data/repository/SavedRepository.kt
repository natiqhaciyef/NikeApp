package com.natiqhaciyef.nikeapp.data.repository

import com.natiqhaciyef.nikeapp.data.datasource.AppDataSource
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel

class SavedRepository (var dataSource: AppDataSource) {

    suspend fun getAllSaved(): List<SavedModel> = dataSource.getAllSaved()

    suspend fun insertToSaved(savedModel: SavedModel) = dataSource.insertToSaved(savedModel)

    suspend fun updateSaved(savedModel: SavedModel) = dataSource.updateSaved(savedModel)

    suspend fun deleteFromSaved(savedModel: SavedModel) = dataSource.deleteFromSaved(savedModel)
}