package com.joppien.app.smarthome.ui.device

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.joppien.app.smarthome.R
import com.joppien.app.smarthome.databinding.FragmentHomeBinding
import com.joppien.app.smarthome.ui.home.DeviceAdapter
import com.joppien.app.smarthome.ui.home.HomeViewModel
import com.joppien.app.smarthome.ui.models.DeviceModel
import com.joppien.app.smarthome.ui.models.LightModel
import com.joppien.app.smarthome.ui.settings.SettingsFragment

class DeviceFragment : Fragment(R.layout.fragment_home) {

    companion object {
        private const val ITEM_SPACE = 4
    }

    private lateinit var binding: FragmentHomeBinding
    private val adapter: DeviceAdapter by lazy {
        DeviceAdapter(
            { onItemClick(it) },
            { onSwitchLightState(it) }
        )
    }

    private val viewModel: HomeViewModel by lazy { HomeViewModel(requireContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()

        binding.homeRecyclerView.adapter = adapter
        binding.homeRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)

                with(outRect) {
                    if (parent.getChildAdapterPosition(view) == 0) {
                        top = ITEM_SPACE
                    }
                    left = ITEM_SPACE
                    right = ITEM_SPACE
                    bottom = ITEM_SPACE
                }
            }
        })

        setActions()
        setObservers()
    }

    private fun setActions() {
        binding.search.setOnSearchClickListener {
            viewModel.onSearch(binding.search.query)
        }
        binding.starButton.setOnClickListener {
            viewModel.onStarFilterClick()
        }
        binding.settingsButton.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SettingsFragment())
                .commit()
        }
    }

    private fun setObservers() {
        viewModel.deviceItems.observe(viewLifecycleOwner) { adapter.submitList(it) }
        viewModel.starState.observe(viewLifecycleOwner) {
            binding.starButton.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    if (it) R.drawable.ic_full_star else R.drawable.ic_empty_star
                )
            )
        }
    }

    private fun onItemClick(device: DeviceModel) {

    }

    private fun onSwitchLightState(device: LightModel) {
        viewModel.onSwitchLightState(device)
    }

}