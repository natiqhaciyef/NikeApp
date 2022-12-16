package com.natiqhaciyef.nikeapp.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.databinding.ActivityMainBinding
import com.natiqhaciyef.nikeapp.presentation.behavior.BottomNavigationBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> {
                    navigationFragments(R.id.homeFragment)
                    true
                }
                R.id.userFragment -> {
                    navigationFragments(R.id.userFragment)
                    true
                }
                R.id.savedFragment -> {
                    navigationFragments(R.id.savedFragment)
                    true
                }
                R.id.cartFragment -> {
                    navigationFragments(R.id.cartFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun navigationFragments(id: Int){
        binding.fragmentContainerView.findNavController().navigate(id)
    }
}