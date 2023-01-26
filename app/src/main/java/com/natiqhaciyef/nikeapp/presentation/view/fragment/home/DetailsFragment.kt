package com.natiqhaciyef.nikeapp.presentation.view.fragment.home

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.CartPost
import com.natiqhaciyef.nikeapp.data.model.PostModel
import com.natiqhaciyef.nikeapp.data.model.SavedModel
import com.natiqhaciyef.nikeapp.databinding.FragmentDetailsBinding
import com.natiqhaciyef.nikeapp.presentation.viewmodel.CartViewModel
import com.natiqhaciyef.nikeapp.presentation.viewmodel.DetailsViewModel
import com.natiqhaciyef.nikeapp.presentation.viewmodel.SavedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_details.*

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private var cartList = mutableListOf<String>()
    private var savedList = mutableListOf<String>()
    private val viewModel: DetailsViewModel by viewModels()
    private val cartViewModel: CartViewModel by viewModels()
    private val savedViewModel: SavedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailsFragment = this
        observer()
        requireActivity().bottomNavBar.visibility = View.GONE
        val navArgs: DetailsFragmentArgs by navArgs()
        val data = navArgs.post
        binding.post = data
        Glide.with(requireContext()).load(data.imagePng).into(binding.postImageDetails)
        setColors(data.colors)

        //For testing
//        val data =
//            PostModel(name = "AJ", "1234", "1234.png", "76", "basketball", mutableListOf("Red"))
        binding
            .addToCartButton.setOnClickListener {
            val colorsText = data.colors.toString()
            val cartPost = CartPost(
                id = 0,
                name = data.name,
                image = data.image,
                imagePng = data.imagePng,
                category = data.category,
                colors = colorsText,
                price = data.price
            )
            if (cartList.contains(cartPost.name)) {

            } else
                viewModel.insertToCart(cartPost)
            Navigation.findNavController(it).navigate(R.id.cartFragment)
        }

        binding
            .goToHomeBackground.setOnClickListener {
            backToHome(it)
        }

        goToHomeIconFragment.setOnClickListener {
            backToHome(it)
        }

        binding
            .saveSneakerIconEmptyFragment.setOnClickListener {
            val color = data.colors.toString()
            val savedModel = SavedModel(
                id = 0,
                name = data.name,
                image = data.image,
                imagePng = data.imagePng,
                price = data.price,
                category = data.category,
                colors = color
            )
            if (savedList.contains(savedModel.name)) {
            } else
                viewModel.insertToSaved(savedModel)

            binding.saveSneakerIconEmptyFragment.visibility = View.GONE
            binding.saveSneakerIconFilledFragment.visibility = View.VISIBLE
        }
    }

    private fun observer() {
        cartViewModel.getAllCart()
        cartViewModel.cartLiveData.observe(viewLifecycleOwner) {
            for (i in it) {
                cartList.add(i.name)
            }
        }

        savedViewModel.getAllSaved()
        savedViewModel.savedLiveData.observe(viewLifecycleOwner) {
            for (i in it) {
                savedList.add(i.name)
            }
        }
    }

    private fun setColors(colors: List<String>) {
        if (colors.isNotEmpty()) {
            when (colors.size) {
                1 -> {
                    binding.color1.backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor(colors[0]))
                    binding.color2.visibility = View.GONE
                    binding.color3.visibility = View.GONE
                }
                2 -> {
                    binding.color1.backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor(colors[0]))
                    binding.color2.backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor(colors[1]))
                    binding.color3.visibility = View.GONE
                }
                else -> {
                    binding.color1.backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor(colors[0]))
                    binding.color2.backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor(colors[1]))
                    binding.color3.backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor(colors[2]))
                }
            }
        }
    }

    private fun backToHome(view: View) = Navigation.findNavController(view).popBackStack()
}