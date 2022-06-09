package com.joppien.app.smarthome.ui.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import com.joppien.app.smarthome.data.database.HomeRepository

class SettingsViewModel(context: Context) : ViewModel() {

    val homeRepository: HomeRepository by lazy { HomeRepository(context) }

    fun onChangeIpAddress(ip: String) = homeRepository.configureHomeIp(ip)

    fun onChangeHueState(state: Boolean) {

    }
}