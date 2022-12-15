package com.natiqhaciyef.nikeapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.AdvertisementModel
import com.natiqhaciyef.nikeapp.databinding.RecyclerAdvertiseViewBinding

class AdvertisementAdapter(val mContext: Context, var list: MutableList<AdvertisementModel>) :
    RecyclerView.Adapter<AdvertisementAdapter.AdvertisementHolder>() {

    inner class AdvertisementHolder(val binding: RecyclerAdvertiseViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisementHolder {
        val binding: RecyclerAdvertiseViewBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_advertise_view, parent, false)
        return AdvertisementHolder(binding)
    }

    override fun onBindViewHolder(holder: AdvertisementHolder, position: Int) {
        val itemView = holder.binding
        val ad = list[position]
        val id = list[position].id

        itemView.adModel = ad
        itemView.adImageView.setImageResource(mContext.resources
            .getIdentifier(ad.image, "drawable", mContext.packageName))
    }

    override fun getItemCount(): Int = list.size

}