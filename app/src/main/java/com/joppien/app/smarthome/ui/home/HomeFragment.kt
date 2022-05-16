package com.joppien.app.smarthome.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.joppien.app.smarthome.R
import com.joppien.app.smarthome.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

}