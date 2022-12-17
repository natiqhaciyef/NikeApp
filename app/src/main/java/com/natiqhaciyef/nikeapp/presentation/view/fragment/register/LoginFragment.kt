package com.natiqhaciyef.nikeapp.presentation.view.fragment.register

import android.content.Intent
import android.os.Bundle
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
import com.natiqhaciyef.nikeapp.databinding.FragmentLoginBinding
import com.natiqhaciyef.nikeapp.presentation.view.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

        binding.toRegisterScreenButton.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        binding.toResetPasswordScreenText.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.resetPasswordFragment)
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailTextLogin.text.toString()
            val password = binding.passwordTextLogin.text.toString()
            login(email, password)
        }

        binding.passwordHideEyeLogin.setOnClickListener {
            binding.passwordTextLogin.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.passwordOpenEyeLogin.visibility = View.VISIBLE
            binding.passwordHideEyeLogin.visibility = View.GONE
        }

        binding.passwordOpenEyeLogin.setOnClickListener {
            binding.passwordTextLogin.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.passwordHideEyeLogin.visibility = View.VISIBLE
            binding.passwordOpenEyeLogin.visibility = View.GONE
        }
    }

    private fun login(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }.addOnFailureListener {
            Snackbar.make(requireView(), "Something went wrong", Snackbar.LENGTH_LONG).show()
        }
    }
}