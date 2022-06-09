package com.joppien.app.smarthome.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joppien.app.smarthome.databinding.FragmentHomeDeviceBinding
import com.joppien.app.smarthome.ui.models.DeviceModel
import com.joppien.app.smarthome.ui.models.LightModel

class DeviceAdapter(
    private val onClick: (LightModel) -> Unit,
    private val onSwitchLightState: (LightModel) -> Unit
) :
    ListAdapter<LightModel, DeviceViewHolder>(DeviceDiffCallback) {

    private lateinit var binding: FragmentHomeDeviceBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        binding = FragmentHomeDeviceBinding.inflate(LayoutInflater.from(parent.context))
        return DeviceViewHolder(binding.root, onClick)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        val device = getItem(position)

        binding.title.text = device.customName ?: device.internalName ?: "Unknown"
        binding.subtitle.text = device.roomName
        binding.lightState.isChecked = device.lightState

        binding.lightState.setOnCheckedChangeListener { _, isChecked ->
            onSwitchLightState(device.apply { lightState = isChecked })
        }
    }

}

class DeviceViewHolder(itemView: View, val onClick: (LightModel) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    private val currentDevice: LightModel? = null

    init {
        itemView.setOnClickListener {
            currentDevice?.let(onClick)
        }
    }

}

object DeviceDiffCallback : DiffUtil.ItemCallback<LightModel>() {
    override fun areItemsTheSame(oldItem: LightModel, newItem: LightModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LightModel, newItem: LightModel): Boolean {
        return oldItem.id == newItem.id
    }

}