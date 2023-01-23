package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.Resource
import com.natiqhaciyef.nikeapp.data.repository.CartInterface
import com.natiqhaciyef.nikeapp.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(val repo: CartInterface) : BaseViewModel() {
    val cartLiveData = MutableLiveData<List<CartPost>>()
    private val deleteMessage = MutableLiveData<Resource<CartPost>>()
    val deleteMessageString: LiveData<Resource<CartPost>>
        get() = deleteMessage


    init {
        getAllCart()
    }

    fun deleteFromCart(cartPost: CartPost) {
        viewModelScope.launch(Dispatchers.Main) {
            if (cartPost.id != null && cartPost.id != 0) {
                repo.deleteFromCart(cartPost)
                deleteMessage.postValue(Resource.success(cartPost))
            } else {
                deleteMessage.postValue(Resource.error("id is not correct", null))
            }
        }
    }

    fun getAllCart() {
        viewModelScope.launch(Dispatchers.Main) {
            cartLiveData.value = repo.getAllCart()
        }
    }
}