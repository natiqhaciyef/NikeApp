package com.natiqhaciyef.nikeapp.presentation.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.databinding.FragmentHomeBinding
import com.natiqhaciyef.nikeapp.presentation.fragment.adapter.PostAdapter


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var postAdapter: PostAdapter
    private var postList = mutableListOf(
        PostModel(1,"Air Jordan 13","nike_air_jordan_13" ,200),
        PostModel(2,"Air Jordan 12 Retro","nike_air_jordan_12_retro" ,175),
        PostModel(3,"Air Jordan 7 Retro","nike_air_jordan_7_retro" ,150),
        PostModel(4,"Air Jordan 9 Retro","nike_air_jordan_9_retro" ,150),
        PostModel(5,"Air Jordan XXXVII","nike_air_jordan_xxxvii" ,205),
        PostModel(6,"Air Max 1 NH","nike_air_max_1_nh" ,150),
        PostModel(7,"Air Zoom Flight 95","nike_air_zoom_flight_95" ,160),
        PostModel(8,"Air Dunk High Retro","nike_air_dunk_high_retro_yellow" ,85),
        PostModel(9,"Kyrie 5 Infinity","nike_kyrie_infinity_5" ,160),
        PostModel(10,"LeBron 19 Low","nike_lebron_19_low" ,100)
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
        postAdapter = PostAdapter(requireContext(), postList)
        binding.postRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.postAdapter = postAdapter
    }
}