package com.natiqhaciyef.nikeapp.presentation.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.databinding.RecyclerPostsViewBinding
import com.natiqhaciyef.nikeapp.presentation.view.fragment.home.HomeFragmentDirections

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
        Glide.with(mContext).load(post.image).into(itemView.sneakerImage)

        itemView.sneakerToDetailsSwitch.setOnClickListener { navigateToDetails(it, post) }
        itemView.sneakerSwitchArrow.setOnClickListener { navigateToDetails(it, post) }
    }

    override fun getItemCount(): Int = list.size

    private fun navigateToDetails(view: View, post: PostModel) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(post)
        Navigation.findNavController(view).navigate(action)
    }
}