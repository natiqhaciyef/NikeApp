package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.Resource
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.repository.CartInterface
import com.natiqhaciyef.nikeapp.data.repository.CartRepository
import com.natiqhaciyef.nikeapp.data.repository.SavedInterface
import com.natiqhaciyef.nikeapp.data.repository.SavedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    var cartRepo: CartInterface,
    var savedRepo: SavedInterface
) : BaseViewModel() {

    private val insertCartMessage = MutableLiveData<Resource<CartPost>>()
    val insertCartMessageString: LiveData<Resource<CartPost>>
        get() = insertCartMessage

    fun insertToCart(cartPost: CartPost) {
        viewModelScope.launch(Dispatchers.Main) {
            if (cartPost.id == 0 && cartPost.category.isNotEmpty() &&
                cartPost.colors.isNotEmpty() && cartPost.image.isNotEmpty() &&
                cartPost.imagePng.isNotEmpty() && cartPost.name.isNotEmpty() &&
                cartPost.price.isNotEmpty()
            ) {
                cartRepo.insertToCart(cartPost)
                insertCartMessage.postValue(Resource.success(cartPost))
            } else {
                insertCartMessage.postValue(Resource.error("some fields are not correct filled", null))
            }
        }
    }


    private val insertSavedMessage = MutableLiveData<Resource<SavedModel>>()
    val insertSavedMessageString: LiveData<Resource<SavedModel>>
        get() = insertSavedMessage

    fun insertToSaved(savedModel: SavedModel) {
        viewModelScope.launch(Dispatchers.Main) {
            if (savedModel.id == 0 && savedModel.name.isNotEmpty() &&
                savedModel.colors.isNotEmpty() && savedModel.image.isNotEmpty() &&
                savedModel.category.isNotEmpty() && savedModel.imagePng.isNotEmpty() &&
                savedModel.price.isNotEmpty()
            ) {
                savedRepo.insertToSaved(savedModel)
                insertSavedMessage.postValue(Resource.success(savedModel))
            }else{
                insertSavedMessage.postValue(Resource.error("some fields are not correct filled", null))
            }
        }

    }
}