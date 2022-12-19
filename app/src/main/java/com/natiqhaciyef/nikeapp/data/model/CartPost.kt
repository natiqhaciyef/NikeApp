package com.natiqhaciyef.nikeapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("cart_model")
data class CartPost(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") var id: Int,
    @ColumnInfo("name") var name: String,
    @ColumnInfo("image") var image: String,
    @ColumnInfo("imagePng") var imagePng: String,
    @ColumnInfo("price") var price: String,
    @ColumnInfo("category") var category: String,
    @ColumnInfo("colors") var colors: String
): Serializable
