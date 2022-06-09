package com.joppien.app.smarthome.ui.models

data class DeviceModel(
    val id: String,
    var internalName: String?,
    var customName: String?,
    var roomName: String?,
    var deviceType: Int,
    var isStarred: Boolean,
    var lightState: Boolean
)