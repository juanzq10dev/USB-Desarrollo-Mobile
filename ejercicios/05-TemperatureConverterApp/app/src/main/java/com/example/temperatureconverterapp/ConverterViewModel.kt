package com.example.temperatureconverterapp

import androidx.core.text.isDigitsOnly
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class ConverterViewModel: ViewModel() {
    var celcius = MutableLiveData<String>("")
    var fahrenheit = MutableLiveData<String>("")

    var isValid = celcius.map {
        if (celcius.value?.isEmpty() == true || celcius.value?.isBlank() == true) {
            false
        } else {
            if (celcius.value?.toDoubleOrNull() == null ) {
                celcius.value = ""
                fahrenheit.value = "The value is invalid"
                false
            } else {
                true
            }
        }
    }

    fun convert() {
        val cel = celcius.value?.toDouble()
        val fahr = (cel?.times(9)?.div(5)?.plus(32) )
        fahrenheit.value = "The Fahrenheit temperature is $fahr"
    }
}