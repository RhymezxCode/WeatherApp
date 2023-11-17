package com.zseni.weatherapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [WeatherEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): WeatherDao
}