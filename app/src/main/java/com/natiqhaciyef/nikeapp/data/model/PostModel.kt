package com.natiqhaciyef.nikeapp.data.model

import java.io.Serializable

data class PostModel(
    var name: String,
    var image: String,
    var imagePng: String,
    var price: String,
    var colors: List<String>
): Serializable
