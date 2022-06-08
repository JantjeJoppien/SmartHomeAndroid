package com.joppien.app.smarthome.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joppien.app.smarthome.data.database.device.DeviceDao
import com.joppien.app.smarthome.data.database.device.DeviceEntity
import com.joppien.app.smarthome.data.database.home.HomeDao
import com.joppien.app.smarthome.data.database.home.HomeEntity

@Database(
    entities = [DeviceEntity::class, HomeEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun deviceDao(): DeviceDao

    abstract fun homeDao(): HomeDao

}