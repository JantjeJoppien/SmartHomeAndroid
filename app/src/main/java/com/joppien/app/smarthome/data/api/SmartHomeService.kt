package com.joppien.app.smarthome.data.api

import com.joppien.app.smarthome.data.api.models.DeviceMetadataResponse
import com.joppien.app.smarthome.data.api.models.HomeRequest
import com.joppien.app.smarthome.data.api.models.LightResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface SmartHomeService {

    @PUT("/home")
    fun setConfiguredDeviceTypes(homeRequest: HomeRequest)

    @GET("/light/configure")
    fun getConfigurableLightsList(): List<DeviceMetadataResponse>

    @GET("/light/configure")
    fun setConfiguredLights(configuredDevices: List<DeviceMetadataResponse>)

    @GET("/light")
    fun getConfiguredLightList(): List<LightResponse>

    @GET("/light/{id}")
    fun getLight(@Path("id") id: String): LightResponse

    @PUT("/light/{id}")
    fun setLight(@Path("id") id: String, @Body lightRequest: LightResponse)

}