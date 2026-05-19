package com.ab.counter.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter_table")
data class CounterEntity(
    @PrimaryKey
    val id : Int =1,
    val count : Int
)
