package com.natiqhaciyef.nikeapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.nikeapp.databinding.ActivityMainBinding
import com.natiqhaciyef.nikeapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}