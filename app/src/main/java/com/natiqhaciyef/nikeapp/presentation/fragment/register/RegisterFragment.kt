package com.natiqhaciyef.nikeapp.presentation.fragment.register

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.databinding.FragmentRegisterBinding
import com.natiqhaciyef.nikeapp.presentation.activity.MainActivity


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

        if (auth.currentUser != null)
            navigateToMainActivity()

        binding.toLoginScreenButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        }

        binding.registerButton.setOnClickListener {
            val email = binding.emailTextRegister.text.toString()
            val password = binding.passwordTextRegister.text.toString()
            register(email, password)
        }

        binding.passwordHideEyeRegister.setOnClickListener {
            binding.passwordTextRegister.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.passwordOpenEyeRegister.visibility = View.VISIBLE
            binding.passwordHideEyeRegister.visibility = View.GONE
        }

        binding.passwordOpenEyeRegister.setOnClickListener {
            binding.passwordTextRegister.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.passwordHideEyeRegister.visibility = View.VISIBLE
            binding.passwordOpenEyeRegister.visibility = View.GONE
        }
    }

    private fun register(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            navigateToMainActivity()
        }.addOnFailureListener {
            Snackbar.make(requireView(), "Something went wrong", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun navigateToMainActivity(){
        val intent = Intent(requireActivity(), MainActivity::class.java)
        requireActivity().startActivity(intent)
        requireActivity().finish()
    }
}