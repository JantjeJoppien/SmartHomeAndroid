package com.joppien.app.smarthome.data.managers

import android.content.Context
import com.google.gson.GsonBuilder
import com.joppien.app.smarthome.data.api.SmartHomeService
import com.joppien.app.smarthome.data.database.AppDatabase
import com.joppien.app.smarthome.data.database.HomeRepository
import com.joppien.app.smarthome.data.database.device.DeviceDao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LightManager(context: Context, serviceIpAddress: String?) {

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

}