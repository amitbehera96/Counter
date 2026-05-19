package com.ab.counter.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterRepository @Inject constructor(private val counterDao: CounterDao){

    fun getCounter() : Flow<CounterEntity> {
        return counterDao.getCounter()
    }

    suspend fun saveCounter(count : Int){
        counterDao.saveCounter(
            CounterEntity(
                count = count
            )
        )
    }

    suspend fun deleteCounter(
        counterEntity: CounterEntity
    ){
        counterDao.deleteCounter(counterEntity)
    }
}