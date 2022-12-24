package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(val repo: CartRepository): BaseViewModel() {
    val cartLiveData = MutableLiveData<List<CartPost>>()

    init {
        getAllCart()
    }

    fun deleteFromCart(cartPost: CartPost){
        viewModelScope.launch(Dispatchers.Main) {
            repo.deleteFromCart(cartPost)
        }
    }

    fun getAllCart(){
        viewModelScope.launch(Dispatchers.Main) {
            cartLiveData.value = repo.getAllCart()
        }
    }
}