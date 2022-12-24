package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.repository.SavedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(val repo: SavedRepository) : BaseViewModel(){
    val savedLiveData = MutableLiveData<List<SavedModel>>()

    init {
        getAllSaved()
    }

    fun getAllSaved(){
        viewModelScope.launch(Dispatchers.Main) { savedLiveData.value = repo.getAllSaved() }
    }

    fun deleteFromSaved(savedModel: SavedModel){
        viewModelScope.launch(Dispatchers.Main) { repo.deleteFromSaved(savedModel) }
    }
}