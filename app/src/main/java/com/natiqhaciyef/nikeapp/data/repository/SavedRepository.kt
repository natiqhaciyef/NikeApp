package com.natiqhaciyef.nikeapp.data.repository

import com.natiqhaciyef.nikeapp.data.datasource.AppDataSource
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import javax.inject.Inject

class SavedRepository @Inject constructor(var dataSource: AppDataSource): SavedInterface {

    override suspend fun getAllSaved(): List<SavedModel> = dataSource.getAllSaved()

    override suspend fun insertToSaved(savedModel: SavedModel) = dataSource.insertToSaved(savedModel)

    suspend fun updateSaved(savedModel: SavedModel) = dataSource.updateSaved(savedModel)

    override suspend fun deleteFromSaved(savedModel: SavedModel) = dataSource.deleteFromSaved(savedModel)
}