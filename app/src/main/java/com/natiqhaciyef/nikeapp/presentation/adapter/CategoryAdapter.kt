package com.natiqhaciyef.nikeapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.CategoryModel
import com.natiqhaciyef.nikeapp.databinding.RecyclerCategoryViewBinding

class CategoryAdapter(val mContext: Context, var list: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    inner class CategoryHolder(var binding: RecyclerCategoryViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val binding: RecyclerCategoryViewBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_category_view, parent, false)
        return CategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val itemView = holder.binding
        val category = list[position]

        itemView.categoryModel = category
    }

    override fun getItemCount(): Int = list.size

}
