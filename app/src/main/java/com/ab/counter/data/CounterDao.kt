package com.ab.counter.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CounterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCounter(counter : CounterEntity)


    @Query("SELECT * FROM counter_table WHERE id =1")
    fun getCounter(): Flow<CounterEntity>

    @Delete
    suspend fun deleteCounter(counter: CounterEntity)
}