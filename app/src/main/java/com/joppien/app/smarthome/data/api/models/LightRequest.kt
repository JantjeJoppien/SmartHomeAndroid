package com.joppien.app.smarthome.data.api.models

import com.google.gson.annotations.SerializedName
import com.joppien.app.smarthome.ui.models.LightModel

data class LightRequest(
    @SerializedName("deviceType")
    val deviceType: Int,
    @SerializedName("state")
    var lightState: Boolean,
    @SerializedName("brightness")
    var brightness: Float?,
    @SerializedName("color")
    var lightColor: LightColor?
) {
    constructor(lightModel: LightModel) : this(
        deviceType = lightModel.deviceType,
        lightState = lightModel.lightState,
        brightness = lightModel.brightness,
        lightColor = null
    )
}