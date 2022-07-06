package com.bootcamp.imdb.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.imdb.R
import com.bootcamp.imdb.databinding.FragmentProfileBinding
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val bdFirestore = FirebaseFirestore.getInstance()
        val userId = FirebaseAuth.getInstance().uid

        //Mostrar nombre de usuario
        bdFirestore.collection("users").document(userId.toString()).get().addOnSuccessListener { documentSnapshot ->
            val userName = documentSnapshot.getString("username")
            binding.nameUserTxt.text = userName
        }

        //RecyclerView Horizontal
        binding.recyclerViewProfile.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ProfileAdapter()
        }
    }
}