package com.joppien.app.smarthome.data.database.device

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device")
data class DeviceEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "internal_name")
    var internalName: String?,
    @ColumnInfo(name = "custom_name")
    var customName: String?,
    @ColumnInfo(name = "room_name")
    var roomName: String?,
    @ColumnInfo(name = "device_type")
    var deviceType: Int,
    @ColumnInfo(name = "is_starred")
    var isStarred: Boolean
)