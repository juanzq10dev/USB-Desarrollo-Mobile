package com.example.mvvmlogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class LoginViewModel: ViewModel() {
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    var isValid = password.map {
        (password.value?.length ?: 0) >= 6
    }
    fun login() {
        println("Logging with: ${username.value} pass: ${password.value}")
    }

}