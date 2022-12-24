package com.natiqhaciyef.nikeapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.data.util.toCustomList
import com.natiqhaciyef.nikeapp.databinding.RecyclerPostsViewBinding

class SavedPostAdapter(val mContext: Context, val list: MutableList<SavedModel>):
    RecyclerView.Adapter<SavedPostAdapter.SavedPostHolder>(){

    inner class SavedPostHolder(val binding: RecyclerPostsViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedPostHolder {
        val binding = RecyclerPostsViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return SavedPostHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedPostHolder, position: Int) {
        val itemView = holder.binding
        val savedPost = list[position]
        val colors = savedPost.colors.toCustomList()
        itemView.postModel =
            PostModel(savedPost.name, savedPost.image, savedPost.imagePng, savedPost.price, savedPost.category, colors)
        Glide.with(mContext).load(savedPost.image).into(itemView.sneakerImage)
    }

    override fun getItemCount(): Int = list.size

}