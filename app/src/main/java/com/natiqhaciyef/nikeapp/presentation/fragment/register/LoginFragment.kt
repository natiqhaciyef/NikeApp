package com.natiqhaciyef.nikeapp.presentation.fragment.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toRegisterScreenButton.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        binding.toResetPasswordScreenText.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.resetPasswordFragment)
        }
    }
}