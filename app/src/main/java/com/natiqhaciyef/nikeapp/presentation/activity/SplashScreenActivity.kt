package com.natiqhaciyef.nikeapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.nikeapp.databinding.ActivityMainBinding
import com.natiqhaciyef.nikeapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}