package com.joppien.app.smarthome.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.joppien.app.smarthome.R
import com.joppien.app.smarthome.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSettingsBinding.inflate(layoutInflater)
    }

}