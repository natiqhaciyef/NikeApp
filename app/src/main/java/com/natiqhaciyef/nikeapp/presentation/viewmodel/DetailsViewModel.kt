package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(var repo: AppRepository): BaseViewModel() {

    fun insertToCart(cartPost: CartPost){
        viewModelScope.launch(Dispatchers.Main) {
            repo.insertToCart(cartPost)
        }
    }

    fun updateFromCart(cartPost: CartPost){
        viewModelScope.launch(Dispatchers.Main) {
            repo.updateCart(cartPost)
        }
    }
}