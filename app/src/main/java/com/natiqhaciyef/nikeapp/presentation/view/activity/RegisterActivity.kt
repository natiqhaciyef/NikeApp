package com.natiqhaciyef.nikeapp.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.nikeapp.databinding.ActivityMainBinding
import com.natiqhaciyef.nikeapp.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}