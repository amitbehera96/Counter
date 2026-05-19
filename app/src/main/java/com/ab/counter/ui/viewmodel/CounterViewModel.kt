package com.ab.counter.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ab.counter.data.CounterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.ab.counter.data.CounterEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@HiltViewModel
class CounterViewModel @Inject constructor(private val repository: CounterRepository) :
    ViewModel() {

    private val _counter = MutableStateFlow(0)
    val count: StateFlow<Int> = _counter

    init {

        observeCounter()
    }

    private fun observeCounter() {
        viewModelScope.launch {
            repository.getCounter().collectLatest {
                _counter.value = it?.count ?: 0
            }
        }
    }

    fun increment() {
        viewModelScope.launch {
            repository.saveCounter(_counter.value + 1)
        }
    }

    fun decrement() {
        viewModelScope.launch {
            if (_counter.value > 0)
                repository.saveCounter(_counter.value - 1)
        }
    }

    fun resetCounter() {

        viewModelScope.launch {

            repository.deleteCounter(
                CounterEntity(
                    id = 1,
                    count = _counter.value
                )
            )

            _counter.value = 0
        }
    }
}