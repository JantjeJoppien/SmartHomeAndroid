package com.joppien.app.smarthome.data.api.models

import com.google.gson.annotations.SerializedName

data class LightResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    var name: String?,
    @SerializedName("state")
    var lightState: Boolean,
    @SerializedName("brightness")
    var brightness: Float?,
    @SerializedName("color")
    var lightColor: LightColor?,
    @SerializedName("deviceType")
    val deviceType: Int
)

data class LightColor(
    @SerializedName("xy")
    val generalXYValues: LightColorXY,
    @SerializedName("gamut")
    val gamut: LightColorGamut?
)

data class LightColorGamut(
    @SerializedName("red")
    val redXYValues: LightColorXY,
    @SerializedName("green")
    val greenXYValues: LightColorXY,
    @SerializedName("blue")
    val blueXYValues: LightColorXY
)

data class LightColorXY(
    @SerializedName("x")
    val xValue: Float,
    @SerializedName("y")
    val yValue: Float
)