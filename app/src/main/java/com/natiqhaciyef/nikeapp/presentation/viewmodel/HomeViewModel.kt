package com.natiqhaciyef.nikeapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.data.model.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {
    val postLiveData = MutableLiveData<ResponseResult.Success<List<PostModel>>>()
    val isLoading = MutableLiveData(false)

    init {
        loadFromFirestore()
    }

    private fun loadFromFirestore() {
        val db = Firebase.firestore
        val postList = ArrayList<PostModel>()
        isLoading.value = true
        viewModelScope.launch(Dispatchers.Main) {
            db.collection("Post").addSnapshotListener { value, error ->
                if (value != null && !value.isEmpty) {
                    val docs = value.documents
                    postList.clear()
                    for (doc in docs) {
                        val name = doc.get("name") as String
                        val image = doc.get("image") as String
                        val imagePng = doc.get("imagePng") as String
                        val price = doc.get("price") as String
                        val category = doc.get("category") as String
                        val colors = doc.get("colors") as ArrayList<String>
                        val post = PostModel(name, image, imagePng, price, category, colors)
                        postList.add(post)
                    }
                    postLiveData.value = ResponseResult.Success(postList)
                    isLoading.value = false
                }
            }
        }
    }

    fun categoryFilter(category: String, list: MutableList<PostModel>): MutableList<PostModel> {
        var customList = mutableListOf<PostModel>()
        if (category.lowercase() != "all" && category.isNotEmpty() && category.lowercase() != "" && category.lowercase() != "bütün") {
            if (category.lowercase() == "running" || category.lowercase() == "qaçış") {
                for (element in list) {
                    if (element.category.lowercase() == "running")
                        customList.add(element)
                }
            } else if (category.lowercase() == "sneaker" || category.lowercase() == "idman") {
                for (element in list) {
                    if (element.category.lowercase() == "sneaker")
                        customList.add(element)
                }
            } else if (category.lowercase() == "basketball" || category.lowercase() == "basketbol") {
                for (element in list) {
                    if (element.category.lowercase() == "basketball")
                        customList.add(element)
                }
            } else if (category.lowercase() == "casual" || category.lowercase() == "gündəlik") {
                for (element in list) {
                    if (element.category.lowercase() == "casual")
                        customList.add(element)
                }
            }
        } else {
            customList = list
        }

        return customList
    }
}