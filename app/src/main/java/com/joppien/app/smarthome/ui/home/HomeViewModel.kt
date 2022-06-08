package com.joppien.app.smarthome.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joppien.app.smarthome.data.managers.LightManager
import com.joppien.app.smarthome.ui.models.DeviceModel

class HomeViewModel(context: Context) {

    private val lightManager: LightManager by lazy { LightManager(context = context) }

    private val _deviceItems: MutableLiveData<List<DeviceModel>> = MutableLiveData()
    val deviceItems: LiveData<List<DeviceModel>> = _deviceItems

    fun onViewCreated() {

    }

    fun onSearch() {

    }

}