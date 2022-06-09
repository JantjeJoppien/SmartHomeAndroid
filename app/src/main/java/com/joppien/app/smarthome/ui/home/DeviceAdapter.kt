package com.joppien.app.smarthome.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joppien.app.smarthome.databinding.FragmentHomeDeviceBinding
import com.joppien.app.smarthome.ui.models.DeviceModel

class DeviceAdapter(private val onClick: (DeviceModel) -> Unit, private val omSwitchLightState: (Boolean) -> Unit) :
    ListAdapter<DeviceModel, DeviceViewHolder>(DeviceDiffCallback) {

    private lateinit var binding: FragmentHomeDeviceBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        binding = FragmentHomeDeviceBinding.inflate(LayoutInflater.from(parent.context))
        return DeviceViewHolder(binding.root, onClick)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        val device = getItem(position)

        binding.title.text = device.customName ?: device.internalName ?: "Unknown"
        binding.subtitle.text = device.roomName
    }

}

class DeviceViewHolder(itemView: View, val onClick: (DeviceModel) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val currentDevice: DeviceModel? = null

    init {
        itemView.setOnClickListener {
            currentDevice?.let(onClick)
        }
    }

}

object DeviceDiffCallback : DiffUtil.ItemCallback<DeviceModel>() {
    override fun areItemsTheSame(oldItem: DeviceModel, newItem: DeviceModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DeviceModel, newItem: DeviceModel): Boolean {
        return oldItem.id == newItem.id
    }

}