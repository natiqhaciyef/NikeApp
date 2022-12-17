package com.natiqhaciyef.nikeapp.presentation.view.fragment.register

import android.os.Bundle
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
import com.natiqhaciyef.nikeapp.databinding.FragmentResetPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment() {
    private lateinit var binding: FragmentResetPasswordBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth

        binding.goToLoginAngleButton.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        binding.sendButton.setOnClickListener {
            val email = binding.emailTextReset.text.toString()
            resetPassword(email)
        }
    }

    private fun resetPassword(email: String){
        auth.sendPasswordResetEmail(email).addOnSuccessListener {
            Snackbar.make(requireView(), "Message sent to email address", Snackbar.LENGTH_LONG).show()
        }.addOnFailureListener {
            Snackbar.make(requireView(), "Something went wrong", Snackbar.LENGTH_LONG).show()
        }
    }
}