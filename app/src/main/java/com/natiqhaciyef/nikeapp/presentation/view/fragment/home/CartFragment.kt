package com.natiqhaciyef.nikeapp.presentation.view.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.databinding.FragmentCartBinding
import com.natiqhaciyef.nikeapp.presentation.adapter.CartAdapter
import com.natiqhaciyef.nikeapp.presentation.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: CartAdapter
    private var list = mutableListOf<CartPost>()
    private val viewModel: CartViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        ItemTouchHelper(swipeCallBack).attachToRecyclerView(binding.recyclerCart)
    }

    private fun observeLiveData() {
        viewModel.cartLiveData.observe(viewLifecycleOwner) {
            list = it.toMutableList()
            adapter = CartAdapter(requireContext(), list)
            binding.cartAdapter = adapter

            binding.isEmptyText.visibility = if(list.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private val swipeCallBack = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.layoutPosition
            val chosenArt = adapter.list[position]
            viewModel.deleteFromCart(chosenArt)
        }
    }
}