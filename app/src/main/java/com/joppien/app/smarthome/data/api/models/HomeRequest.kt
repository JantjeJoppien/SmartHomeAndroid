package com.joppien.app.smarthome.data.api.models

import com.google.gson.annotations.SerializedName

data class HomeRequest(
    @SerializedName("philipsHueEnabled")
    var philipsHueEnabled: Boolean
)