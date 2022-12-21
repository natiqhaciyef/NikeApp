package com.natiqhaciyef.nikeapp.presentation.view.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.util.monthFinder
import com.natiqhaciyef.nikeapp.data.util.yearFinder
import com.natiqhaciyef.nikeapp.databinding.FragmentUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Date
import kotlin.time.days

@AndroidEntryPoint
class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().bottomNavBar.visibility = View.GONE
        auth = Firebase.auth
        auth.currentUser?.let{
            binding.userEmailText.text = "Email: ${it.email}"
            val date = Date(it.metadata!!.creationTimestamp)

            binding.joinDataText.text = "Join date: ${date.date} ${monthFinder(date.month)} ${yearFinder(date.year)}"
        }

        binding.signOutButton.setOnClickListener {
//            auth.signOut()
        }
    }
}