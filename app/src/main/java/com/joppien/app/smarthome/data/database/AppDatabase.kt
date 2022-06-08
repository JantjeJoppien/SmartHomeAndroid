package com.joppien.app.smarthome.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.joppien.app.smarthome.data.database.device.DeviceDao
import com.joppien.app.smarthome.data.database.device.DeviceEntity

@Database(
    entities = [DeviceEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun deviceDao(): DeviceDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}