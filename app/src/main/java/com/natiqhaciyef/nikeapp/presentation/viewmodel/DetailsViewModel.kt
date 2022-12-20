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
    val cartLiveData = MutableLiveData<List<CartPost>>()

    init {
        getAllCart()
    }

    fun insertToCart(cartPost: CartPost){
        viewModelScope.launch(Dispatchers.Main) {
            repo.insertToCart(cartPost)
        }
    }

    fun getAllCart(){
        viewModelScope.launch(Dispatchers.Main) {
            cartLiveData.value = repo.getAllCart()
        }
    }
}