package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.nikeapp.data.model.Resource
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.repository.SavedInterface
import com.natiqhaciyef.nikeapp.data.repository.SavedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(val repo: SavedInterface) : BaseViewModel() {
    val savedLiveData = MutableLiveData<List<SavedModel>>()

    private val deleteMessage = MutableLiveData<Resource<SavedModel>>()
    val deleteMessageString: LiveData<Resource<SavedModel>>
        get() = deleteMessage

    init {
        getAllSaved()
    }

    fun getAllSaved() {
        viewModelScope.launch(Dispatchers.Main) { savedLiveData.value = repo.getAllSaved() }
    }

    fun deleteFromSaved(savedModel: SavedModel) {
        viewModelScope.launch(Dispatchers.Main) {
            if (savedModel.id != 0 &&
                savedModel.price.isNotEmpty() &&
                savedModel.imagePng.isNotEmpty() &&
                savedModel.category.isNotEmpty() &&
                savedModel.image.isNotEmpty() &&
                savedModel.name.isNotEmpty() &&
                savedModel.colors.isNotEmpty()
            ) {
                repo.deleteFromSaved(savedModel)
                deleteMessage.postValue(Resource.success(savedModel))
            }else{
                deleteMessage.postValue(Resource.error("something went wrong",null))
            }
        }
    }
}