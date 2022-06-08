package com.joppien.app.smarthome.data.database

import android.content.Context
import android.content.SharedPreferences

class HomeRepository(context: Context) {

    companion object {
        private const val PREFERENCE_NAME = "com.joppien.app.smarthome.HOME"
    }

    private val sharedPref: SharedPreferences by lazy {
        context.getSharedPreferences(
            PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun configureHomeId(id: String) {
        with(sharedPref.edit()) {
            putString(PREFERENCE_NAME, id)
            apply()
        }
    }

    fun getHomeId() = sharedPref.getString(PREFERENCE_NAME, null)

}