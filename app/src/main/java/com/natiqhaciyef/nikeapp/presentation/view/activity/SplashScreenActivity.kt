package com.natiqhaciyef.nikeapp.presentation.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.nikeapp.databinding.ActivitySplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            navigateToRegisterActivity()
        }

        binding.getStartButton.setOnClickListener {
            navigateToRegisterActivity()
        }
    }

    private fun navigateToRegisterActivity(){
        val intent = Intent(this@SplashScreenActivity, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}