package com.joppien.app.smarthome.data.managers

import android.content.Context
import com.google.gson.GsonBuilder
import com.joppien.app.smarthome.data.api.SmartHomeService
import com.joppien.app.smarthome.data.api.models.LightRequest
import com.joppien.app.smarthome.data.api.models.LightResponse
import com.joppien.app.smarthome.data.database.AppDatabase
import com.joppien.app.smarthome.data.database.HomeRepository
import com.joppien.app.smarthome.data.database.device.DeviceDao
import com.joppien.app.smarthome.ui.models.LightModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LightManager(context: Context) {

    val deviceDao: DeviceDao by lazy {
        AppDatabase.getDatabase(context = context).deviceDao()
    }

    val homeRepository: HomeRepository by lazy { HomeRepository(context) }

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("https://${homeRepository.getHomeId()}/v1")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(SmartHomeService::class.java)
    }

    suspend fun getLightList(): List<LightModel> = webservice.getConfiguredLightList().map {
        LightModel(it, deviceDao.getStarred(it.id))
    }

    suspend fun updateLightData(lightModel: LightModel) {
        webservice.setLight(lightModel.id, LightRequest(lightModel))
    }

}