package com.joppien.app.smarthome.data.database.device

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DeviceDao {

    @Query("SELECT is_starred FROM device WHERE id=:id")
    suspend fun getStarred(id: String): Boolean

    @Insert
    suspend fun insertLightData(deviceEntity: DeviceEntity)

    @Query("DELETE FROM device")
    suspend fun clear()
}