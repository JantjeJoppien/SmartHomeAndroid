package com.joppien.app.smarthome.ui.models

import com.joppien.app.smarthome.data.api.models.LightResponse

open class DeviceModel(
    val id: String,
    var internalName: String?,
    var customName: String?,
    var roomName: String?,
    var deviceType: Int,
    var isStarred: Boolean,
)

class LightModel(
    id: String,
    internalName: String?,
    customName: String?,
    roomName: String?,
    deviceType: Int,
    isStarred: Boolean,
    var lightState: Boolean,
    var brightness: Float?
) : DeviceModel(id, internalName, customName, roomName, deviceType, isStarred) {
    constructor(lightResponse: LightResponse, isStarred: Boolean) : this(
        id = lightResponse.id,
        internalName = lightResponse.internalName,
        customName = lightResponse.customName,
        roomName = lightResponse.roomName,
        deviceType = lightResponse.deviceType,
        isStarred = isStarred,
        lightState = lightResponse.lightState,
        brightness = lightResponse.brightness
    )
}