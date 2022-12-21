package com.natiqhaciyef.nikeapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.databinding.RecyclerCartViewBinding

class CartAdapter(val mContext: Context, var list: MutableList<CartPost>) :
    RecyclerView.Adapter<CartAdapter.CartHolder>() {

        inner class CartHolder(val binding: RecyclerCartViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val binding: RecyclerCartViewBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_cart_view, parent, false)
        return CartHolder(binding)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        val itemView = holder.binding
        val cart = list[position]
        itemView.cartPost = cart

        Glide.with(mContext).load(cart.image).into(itemView.cartPostImage)
    }

    override fun getItemCount(): Int = list.size
}