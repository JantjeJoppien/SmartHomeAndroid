package com.joppien.app.smarthome.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.joppien.app.smarthome.data.managers.LightManager
import com.joppien.app.smarthome.ui.models.DeviceModel
import com.joppien.app.smarthome.ui.models.LightModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(context: Context) : ViewModel() {

    private val lightManager: LightManager by lazy { LightManager(context = context) }

    private var currentItems: List<LightModel> = emptyList()
        set(value) {
            _deviceItems.value = value
            field = value
        }
    private val _deviceItems: MutableLiveData<List<LightModel>> = MutableLiveData()
    val deviceItems: LiveData<List<LightModel>> = _deviceItems

    private var latestStarState: Boolean = false
        set(value) {
            _starState.value = value
            field = value
        }
    private val _starState: MutableLiveData<Boolean> = MutableLiveData()
    val starState: LiveData<Boolean> = _starState


    fun onViewCreated() {
        viewModelScope.launch { loadItems() }
    }

    fun onSearch(query: CharSequence) {
        if (query.isNotBlank()) {
            currentItems = currentItems.filter {
                it.customName?.equals(query) == true || it.internalName?.equals(query) == true || it.id == query
            }
        } else viewModelScope.launch { loadItems() }
    }

    fun onStarFilterClick() {
        currentItems =
            if (latestStarState) currentItems.sortedBy { it.isStarred }
            else currentItems.sortedBy { it.customName ?: it.internalName ?: it.id }
        latestStarState = !latestStarState
    }

    fun onSwitchLightState(device: LightModel) {
        viewModelScope.launch { lightManager.updateLightData(device) }
    }

    private suspend fun loadItems() {
        currentItems =
            lightManager.getLightList().sortedBy { it.customName ?: it.internalName ?: it.id }
    }
}