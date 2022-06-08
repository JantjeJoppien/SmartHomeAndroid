package com.joppien.app.smarthome.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.joppien.app.smarthome.R
import com.joppien.app.smarthome.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by lazy { HomeViewModel(requireContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.onViewCreated()

        binding.search.setOnSearchClickListener {
            homeViewModel.onSearch()
        }

        homeViewModel.deviceItems.observe(viewLifecycleOwner) {

        }
    }

}