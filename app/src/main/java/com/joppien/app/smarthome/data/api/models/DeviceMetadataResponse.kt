package com.joppien.app.smarthome.data.api.models

import com.google.gson.annotations.SerializedName

data class DeviceMetadataResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("internalName")
    var internalName: String?,
    @SerializedName("customName")
    var customName: String?,
    @SerializedName("roomName")
    var roomName: String?
)