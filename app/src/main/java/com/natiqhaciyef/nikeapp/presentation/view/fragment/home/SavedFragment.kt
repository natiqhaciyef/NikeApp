package com.natiqhaciyef.nikeapp.presentation.view.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.databinding.FragmentSavedBinding
import com.natiqhaciyef.nikeapp.presentation.adapter.SavedPostAdapter
import com.natiqhaciyef.nikeapp.presentation.viewmodel.SavedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class SavedFragment : Fragment() {
    private lateinit var binding: FragmentSavedBinding
    private lateinit var adapter: SavedPostAdapter
    private val viewModel: SavedViewModel by viewModels()
    private var list = mutableListOf<SavedModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saved, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.savedFragment = this
        observer()
        ItemTouchHelper(swipeCallBack).attachToRecyclerView(binding.recyclerSavedView)
        requireActivity().bottomNavBar.visibility = View.GONE

    }

    private fun observer(){
        viewModel.savedLiveData.observe(viewLifecycleOwner){
            list = it.toMutableList()
            adapter = SavedPostAdapter(requireContext(), list)
            binding.recyclerSavedView.adapter = adapter
            binding.recyclerSavedView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            binding.isEmpty.visibility = if(list.isEmpty()) View.VISIBLE else View.GONE
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
            viewModel.deleteFromSaved(chosenArt)
        }
    }
}