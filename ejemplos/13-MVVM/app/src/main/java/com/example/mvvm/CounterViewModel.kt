package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    var counter = MutableLiveData<Int>()
    init {
        counter.value = 0
    }

    fun incrementCounter() {
        counter.value = (counter.value)?.plus(1)
    }
}