package com.natiqhaciyef.nikeapp.presentation.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.databinding.RecyclerPostsViewBinding

class PostAdapter(var mContext: Context, var list: MutableList<PostModel>) :
    RecyclerView.Adapter<PostAdapter.PostHolder>() {

    inner class PostHolder(var binding: RecyclerPostsViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding: RecyclerPostsViewBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_posts_view, parent, false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = list[position]
        val itemView = holder.binding

        itemView.postModel = post
//        Glide.with(mContext).load(post.image).into(itemView.sneakerImage)
        itemView.sneakerImage.setImageResource(
            mContext.resources.getIdentifier(post.image, "drawable", mContext.packageName)
        )
    }

    override fun getItemCount(): Int = list.size

}