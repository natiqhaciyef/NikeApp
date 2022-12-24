package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.repository.CartRepository
import com.natiqhaciyef.nikeapp.data.repository.SavedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    var cartRepo: CartRepository,
    var savedRepo: SavedRepository
) : BaseViewModel() {

    fun insertToCart(cartPost: CartPost) {
        viewModelScope.launch(Dispatchers.Main) {
            cartRepo.insertToCart(cartPost)
        }
    }

    fun updateFromCart(cartPost: CartPost) {
        viewModelScope.launch(Dispatchers.Main) {
            cartRepo.updateCart(cartPost)
        }
    }

    fun insertToSaved(savedModel: SavedModel) {
        viewModelScope.launch(Dispatchers.Main) {
            savedRepo.insertToSaved(savedModel)
        }
    }
}