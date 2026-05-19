package com.ab.counter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ab.counter.data.CounterDao
import com.ab.counter.data.CounterEntity

@Database(entities = [CounterEntity :: class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun counterDao() : CounterDao
}