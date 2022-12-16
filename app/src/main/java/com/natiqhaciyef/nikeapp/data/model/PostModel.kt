package com.natiqhaciyef.nikeapp.data.model

import java.io.Serializable

data class PostModel(
    var id: Int,
    var name: String,
    var image: String,
    var price: Int
): Serializable
