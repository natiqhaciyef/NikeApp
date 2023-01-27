package com.natiqhaciyef.nikeapp.presentation.view.fragment.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.data.model.Resource
import com.natiqhaciyef.nikeapp.data.util.monthFinder
import com.natiqhaciyef.nikeapp.data.util.yearFinder
import com.natiqhaciyef.nikeapp.databinding.AlertDialogSignOutBinding
import com.natiqhaciyef.nikeapp.databinding.FragmentUserBinding
import com.natiqhaciyef.nikeapp.presentation.view.activity.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_user.*
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
//        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().bottomNavBar.visibility = View.GONE
        auth = Firebase.auth
        auth.currentUser?.let {
            binding
                .userEmailText.text = "Email: ${it.email}"
            val date = Date(it.metadata!!.creationTimestamp)

            binding
                .joinDataText.text =
                "Join date: ${date.date} ${monthFinder(date.month)} ${yearFinder(date.year)}"
        }

        binding
            .signOutButton.setOnClickListener {
            userSignOut()

            }
    }

    fun userSignOut() {
        val view = AlertDialogSignOutBinding.inflate(layoutInflater)
        val yes = view.positiveButton
        val no = view.negativeButton

        val customAlert = AlertDialog.Builder(requireContext())
            .setView(view.root)
            .create()

        yes.setOnClickListener {
            auth.signOut()
            customAlert.cancel()
            val intent = Intent(requireActivity(), RegisterActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        no.setOnClickListener {
            findNavController().navigate(R.id.userFragment)
            customAlert.cancel()
        }
        customAlert.show()
    }
}