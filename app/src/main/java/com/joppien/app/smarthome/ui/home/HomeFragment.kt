package com.joppien.app.smarthome.ui.home

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.joppien.app.smarthome.R
import com.joppien.app.smarthome.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    companion object {
        private const val ITEM_SPACE = 4
    }

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

        homeViewModel.deviceItems.observe(viewLifecycleOwner) {

        }
    }

}