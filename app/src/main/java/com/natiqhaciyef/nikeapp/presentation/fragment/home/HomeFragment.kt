package com.natiqhaciyef.nikeapp.presentation.fragment.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.transition.TransitionManager;
import androidx.transition.Transition;
import androidx.transition.Fade;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.objects.AdsList
import com.natiqhaciyef.nikeapp.data.objects.CategoryList
import com.natiqhaciyef.nikeapp.data.objects.PostsList
import com.natiqhaciyef.nikeapp.databinding.FragmentHomeBinding
import com.natiqhaciyef.nikeapp.presentation.adapter.AdvertisementAdapter
import com.natiqhaciyef.nikeapp.presentation.adapter.CategoryAdapter
import com.natiqhaciyef.nikeapp.presentation.adapter.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var handler: Handler
    private lateinit var postAdapter: PostAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var adAdapter: AdvertisementAdapter
    private val runnable = Runnable {
        binding.advertiseViewPager.currentItem =
            binding.advertiseViewPager.currentItem + 1
    }

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
        handler = Handler(Looper.myLooper()!!)
        screenTransformer()

        postAdapter = PostAdapter(requireContext(), PostsList.postList)
        categoryAdapter = CategoryAdapter(requireContext(), CategoryList.list)
        adAdapter = AdvertisementAdapter(requireContext(), AdsList.adsList)

        binding.postRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.postAdapter = postAdapter

        binding.categoriesRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoryAdapter = categoryAdapter

        binding.advertiseViewPager.adapter = adAdapter
        binding.advertiseViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 5000)
            }
        })

        binding.postRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val bottomNavBar = requireActivity().bottomNavBar
                val t = Fade()
                t.duration = 350
                t.addTarget(bottomNavBar)
                TransitionManager.beginDelayedTransition(recyclerView, t as Transition)
                bottomNavBar.visibility =
                    if (dy > 0 && bottomNavBar.isShown) View.GONE
                    else if (dy < 0) View.VISIBLE
                    else View.INVISIBLE

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    private fun screenTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        binding.advertiseViewPager.setPageTransformer(transformer)
    }
}